package com.github.salomonbrys.kodein.internal

import com.github.salomonbrys.kodein.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

/**
 * Container class where the bindings and their factories are stored.
 *
 * In kodein, every binding is stored as a factory.
 * Providers are special classes of factories that take Unit as parameter.
 *
 * @property _map The map containing all bindings.
 * @property _node See [KodeinContainerImpl.Node]
 */
internal class KodeinContainerImpl private constructor(private val _map: CMap, private val _node: Node? = null) : KodeinContainer {

    /**
     * A cache that is filled each time a key is not found directly into the [_map] but by modifying the key's [Kodein.Key.argType].
     */
    private val _cache = HashMap<Kodein.Key, FactoryBinding<*, Any>>()

    /**
     * Class used to check for recursive dependencies, represents a node in the dependency tree.
     *
     * Each factory, in their FactoryBinding@getInstance methods receives a Kodein instance to enable transient dependency.
     * However, it is not the same kodein instance as the one used to get the main dependency.
     * Each time a transient dependency is needed, a new Kodein instance is constructed, with a new Node that has
     * the current Node as it's parent.
     * This allows, at each step, to walk up the node tree and check if the requested key has not yet been requested.
     * If the same key exists twice in the tree, it means that it has, and that there's a dependency recursion.
     *
     * @property _key The key of this node, meaning that this key has been looked for once.
     * @property _parent The parent node, meaning the parent lookup that needed this key.
     */
    private class Node(private val _key: Kodein.Key, private val _overrideLevel: Int, private val _parent: Node?) {

        private fun displayString(key: Kodein.Key, overrideLevel: Int) = if (overrideLevel != 0) "overridden ${key.bind}" else key.bind.toString()

        /**
         * Check that given key does **not** exist in the node tree or throws an exception if it does.
         *
         * @throws Kodein.DependencyLoopException if the key exists in the dependency tree.
         */
        internal fun check(searchedKey: Kodein.Key, searchedOverrideLevel: Int) {
            if (!_check(searchedKey, searchedOverrideLevel))
                throw Kodein.DependencyLoopException("Dependency recursion:\n" + _tree(searchedKey, searchedOverrideLevel) + "\n       ╚═> ${displayString(searchedKey, _overrideLevel)}")
        }

        /**
         * Recursive function that walks up the node tree to check if a specific key can be found.
         *
         * @return whether the given key exists in the tree.
         */
        private fun _check(searchedKey: Kodein.Key, searchedOverrideLevel: Int): Boolean {
            return if (_key == searchedKey && _overrideLevel == searchedOverrideLevel) false else (_parent?._check(searchedKey, searchedOverrideLevel) ?: true)
        }

        /**
         * @return The current transitive dependency tree as a string.
         */
        private fun _tree(firstKey: Kodein.Key, firstOverrideLevel: Int): String {
            if (firstKey == _key && firstOverrideLevel == _overrideLevel)
                return "       ╔═> ${displayString(_key, _overrideLevel)}"
            else
                return "${_parent?._tree(firstKey, firstOverrideLevel)}\n       ╠─> ${displayString(_key, _overrideLevel)}"
        }
    }

    /**
     * "Main" constructor that uses the bindings map configured by a [KodeinContainer.Builder].
     */
    internal constructor(builder: KodeinContainer.Builder) : this(builder._map)

    override val bindings: Map<Kodein.Key, FactoryBinding<*, *>> get() = _map.bindings

    override val overriddenBindings: Map<Kodein.Key, List<FactoryBinding<*, *>>> get() = _map.overrides

    /**
     * The super type of this type.
     *
     * @receiver The type whose super type is needed.
     * @return The super type, or null if this type does not supports it.
     */
    private fun Type.superType(): Type? = when (this) {
        is Class<*> -> this.genericSuperclass
        is ParameterizedType -> this.rawType.superType()
        is KodeinWrappedType -> this.type.superType()
        else -> null
    }

    /**
     * The raw type of this type. Only if *different* from this type.
     *
     * E.g. the raw type of a `Class` (which is already a raw type) is `null`.
     *
     * @receiver The type whose super type is needed.
     * @return The super type, or null if this type does not supports it.
     */
    private fun Type.toRawType(): Type? = when (this) {
        is ParameterizedType -> this.rawType
        is KodeinWrappedType -> this.type.toRawType()
        else -> null
    }

    /**
     * Finds a factory from a key, either in the [_map] or in the [_cache].
     *
     * @param key The key associated to the factory that is requested.
     * @return The factory, or null if non is found in both maps.
     */
    private fun get(key: Kodein.Key) : FactoryBinding<*, Any>? {
        _map[key]?.let { return it }
        _cache[key]?.let { return it }
        return null
    }

    /**
     * Recursive function that tries to find a factory according to the provided key.
     *
     * 1. First, it of course tries with the [key] as is.
     * 2. Then, it tries with the [key] with it's [Kodein.Key.argType] set to the raw type if there is one.
     * 3. Then it goes back to 1, with the [key] with it's [Kodein.Key.argType] set to the super type if there is one.
     * 4. If finally a factory is found, it puts it in the cache associated to the original key, so it will be directly found next time.
     *
     * @param key The key to look for
     * @param cache Whether the function needs to cache the result if a result is found (only the original key should be cached).
     * @return The found factory, or null if none is found.
     */
    private fun _findFactoryOrNull(key: Kodein.Key, cache: Boolean) : FactoryBinding<*, Any>? {
        get(key)?.let { return it }

        val rawType = key.argType.toRawType()
        if (rawType != null) {
            get(Kodein.Key(key.bind, rawType))?.let {
                if (cache)
                    _cache[key] = it
                return it
            }
        }

        val argSuperType = key.argType.superType()
        if (argSuperType == null || argSuperType == Unit::class.java || argSuperType == Any::class.java)
            return null

        val found = _findFactoryOrNull(Kodein.Key(key.bind, argSuperType), false)
        if (cache && found != null)
            _cache[key] = found
        return found
    }

    private fun _transformFactory(factory: FactoryBinding<*, Any>, key: Kodein.Key, overrideLevel: Int): Factory<Any?, Any> {
        _node?.check(key, overrideLevel)
        @Suppress("UNCHECKED_CAST")
        return { arg -> (factory as FactoryBinding<Any?, Any>).getInstance(FactoryKodeinImpl(KodeinContainerImpl(_map, Node(key, overrideLevel, _node)), key, overrideLevel), key, arg) }
    }

    override fun factoryOrNull(key: Kodein.Key): Factory<Any?, Any>? {
        val factory = _findFactoryOrNull(key, true) ?: return null
        return _transformFactory(factory, key, 0)
    }

    override fun overriddenFactoryOrNull(key: Kodein.Key, overrideLevel: Int): Factory<Any?, Any>? {
        val factory = _map.getOverride(key, overrideLevel) ?: return null
        return _transformFactory(factory, key, overrideLevel + 1)
    }
}
