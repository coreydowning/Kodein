package com.github.salomonbrys.kodein

import com.github.salomonbrys.kodein.internal.CMap
import java.lang.reflect.*

/**
 * Container class where the bindings and their factories are stored.
 *
 * In kodein, every binding is stored as a factory (that's why a scope is a function creating a factory).
 * Providers are special classes of factories that take Unit as parameter.
 */
interface KodeinContainer {

    /**
     * An immutable view of the bindings map. *For inspection & debug*.
     */
    val bindings: BindingsMap

    /**
     * An immutable view of the bindings that were defined and later overridden. *For inspection & debug*.
     */
    val overriddenBindings: BindingsListMap

    /**
     * Utility function to create a NotFoundException.
     *
     * @param key The key that was not found.
     * @param scope Type of scope: "factory" or "provider".
     * @return The exception, ready to be thrown away!
     */
    private fun _notFoundException(key: Kodein.Key, scope: String): Kodein.NotFoundException
            = Kodein.NotFoundException(key, "No $scope found for $key\nRegistered in Kodein:\n" + bindings.description)

    /**
     * Retrieve a factory for the given key, or null if none is found.
     *
     * @param key The key to look for.
     * @return The found factory, or null if no factory was found.
     * @throws Kodein.DependencyLoopException When calling the factory function, if the instance construction triggered a dependency loop.
     */
    fun factoryOrNull(key: Kodein.Key): Factory<Any?, Any>?

    /**
     * Retrieve a factory for the given key.
     *
     * @param key The key to look for.
     * @return The found factory.
     * @throws Kodein.NotFoundException If no factory was found.
     * @throws Kodein.DependencyLoopException When calling the factory function, if the instance construction triggered a dependency loop.
     */
    fun nonNullFactory(key: Kodein.Key): Factory<Any?, Any>
            = factoryOrNull(key) ?: throw _notFoundException(key, "factory")

    /**
     * Retrieve a provider for the given bind, or null if none is found.
     *
     * @param bind The bind (type and tag) to look for.
     * @return The found provider, or null if no provider was found.
     * @throws Kodein.DependencyLoopException When calling the provider function, if the instance construction triggered a dependency loop.
     */
    fun providerOrNull(bind: Kodein.Bind): Provider<Any>? {
        val factory = factoryOrNull(Kodein.Key(bind, Unit::class.java)) ?: return null
        return { factory(Unit) }
    }

    /**
     * Retrieve a provider for the given bind.
     *
     * @param bind The bind (type and tag) to look for.
     * @return The found provider.
     * @throws Kodein.NotFoundException If no provider was found.
     * @throws Kodein.DependencyLoopException When calling the provider function, if the instance construction triggered a dependency loop.
     */
    fun nonNullProvider(bind: Kodein.Bind): Provider<Any>
            = providerOrNull(bind) ?: throw _notFoundException(Kodein.Key(bind, Unit::class.java), "provider")


    /**
     * Retrieve an overridden factory for the given key at the given override level, if there is an overridden binding at that level.
     *
     * @param key The key to look for.
     * @param overrideLevel The override level.
     *                      Override level 0 means the first overridden factory (not the "active" binding).
     * @return The overridden factory, or null if there was o binding overridden at that level.
     * @throws Kodein.DependencyLoopException When calling the factory function, if the instance construction triggered a dependency loop.
     */
    fun overriddenFactoryOrNull(key: Kodein.Key, overrideLevel: Int): Factory<Any?, Any>?

    /**
     * Retrieve an overridden factory for the given key at the given override level.
     *
     * @param key The key to look for.
     * @param overrideLevel The override level.
     *                      Override level 0 means the first overridden factory (not the "active" binding).
     * @return The overridden factory.
     * @throws Kodein.NotFoundException If there was no binding overridden at that level.
     * @throws Kodein.DependencyLoopException When calling the factory function, if the instance construction triggered a dependency loop.
     */
    fun overriddenNonNullFactory(key: Kodein.Key, overrideLevel: Int): Factory<Any?, Any>
            = overriddenFactoryOrNull(key, overrideLevel) ?: throw _notFoundException(key, "overridden factory")

    /**
     * Retrieve an overridden provider for the given key at the given override level, if there is an overridden binding at that level.
     *
     * @param bind The key to look for.
     * @param overrideLevel The override level.
     *                      Override level 0 means the first overridden factory (not the "active" binding).
     * @return The overridden provider, or null if there was o binding overridden at that level.
     * @throws Kodein.DependencyLoopException When calling the provider function, if the instance construction triggered a dependency loop.
     */
    fun overriddenProviderOrNull(bind: Kodein.Bind, overrideLevel: Int): Provider<Any>? {
        val factory = overriddenFactoryOrNull(Kodein.Key(bind, Unit::class.java), overrideLevel) ?: return null
        return { factory(Unit) }
    }

    /**
     * Retrieve an overridden provider for the given key at the given override level.
     *
     * @param bind The key to look for.
     * @param overrideLevel The override level.
     *                      Override level 0 means the first overridden factory (not the "active" binding).
     * @return The overridden provider.
     * @throws Kodein.NotFoundException If there was no binding overridden at that level.
     * @throws Kodein.DependencyLoopException When calling the provider function, if the instance construction triggered a dependency loop.
     */
    fun overriddenNonNullProvider(bind: Kodein.Bind, overrideLevel: Int): Provider<Any>
            = overriddenProviderOrNull(bind, overrideLevel) ?: throw _notFoundException(Kodein.Key(bind, Unit::class.java), "overridden provider")


    /**
     * This is where you configure the bindings.
     *
     * @param allowOverride Whether or not the bindings defined by this builder or its imports are allowed to **explicitly** override existing bindings.
     * @param silentOverride Whether or not the bindings defined by this builder or its imports are allowed to **silently** override existing bindings.
     * @property _map The map that contains the bindings. Can be set at construction to construct a sub-builder (with different override permissions).
     */
    class Builder internal constructor(allowOverride: Boolean, silentOverride: Boolean, internal val _map: CMap) {

        /**
         * The override permission for a builder.
         */
        private enum class OverrideMode {

            /**
             * Bindings are allowed to **non-explicit** overrides.
             */
            ALLOW_SILENT {
                override val isAllowed: Boolean get() = true
                override fun must(overrides: Boolean?) = overrides
            },

            /**
             * Bindings are allowed to overrides, but only **explicit**.
             */
            ALLOW_EXPLICIT {
                override val isAllowed: Boolean get() = true
                override fun must(overrides: Boolean?) = overrides ?: false
            },

            /**
             * Bindings are forbidden to override.
             */
            FORBID {
                override val isAllowed: Boolean get() = false
                override fun must(overrides: Boolean?) = if (overrides != null && overrides) throw Kodein.OverridingException("Overriding has been forbidden") else false
            };

            /**
             * Whether or not this mode allows overrides.
             */
            abstract val isAllowed: Boolean

            /**
             * Given a binding overriding declaration (true=yes, false=no, null=maybe), returns whether or not the binding **must** override an existing binding.
             *
             * @return `true` if it must override, `false` if it must not, `null` if it can but is not required to.
             * @throws Kodein.OverridingException If it asks to override, if the binding overriding declaration is not permitted.
             */
            abstract fun must(overrides: Boolean?): Boolean?

            companion object {

                /**
                 * Get the mode according to the given permissions.
                 *
                 * @param allow The permission to override explicitly.
                 * @param silent The permission to override silently.
                 * @return The mode corresponding to the permissions.
                 */
                fun get(allow: Boolean, silent: Boolean): OverrideMode {
                    if (!allow)
                        return FORBID
                    if (silent)
                        return ALLOW_SILENT
                    return ALLOW_EXPLICIT
                }
            }
        }

        /**
         * The mode that defines the overriding permissions for this builder.
         */
        private val _overrideMode = OverrideMode.get(allowOverride, silentOverride)

        /**
         * Checks that a type is reified. Meaning that it is not or does not reference a [TypeVariable].
         *
         * @param disp An object to print if the check fails. *For debug print only*.
         * @param type The type to check.
         * @throws IllegalArgumentException If the type does contain a [TypeVariable].
         */
        private fun _checkIsReified(disp: Any, type: Type) {
            when (type) {
                is TypeVariable<*> -> throw IllegalArgumentException("$disp uses a type variable named ${type.name}, therefore, the bound value can never be retrieved.")
                is ParameterizedType -> for (arg in type.actualTypeArguments) _checkIsReified(disp, arg)
                is GenericArrayType -> _checkIsReified(disp, type.genericComponentType)
                is WildcardType -> {
                    for (arg in type.lowerBounds)
                        _checkIsReified(disp, arg)
                    for (arg in type.upperBounds)
                        _checkIsReified(disp, arg)
                }
                is KodeinWrappedType -> _checkIsReified(disp, type.type)
                is Class<*> -> {}
                else -> throw IllegalArgumentException("Unknown type ${type.javaClass} $type")
            }
        }

        /**
         * Checks that the bindings conforms to it's overriding declaration.
         *
         * If [overrides] is null, only checks if the binding is allowed to override, else checks if it conforms.
         *
         * @param key The key that the binding must, may or must not override.
         * @param overrides `true` if it must override, `false` if it must not, `null` if it can but is not required to.
         * @throws Kodein.OverridingException If overrides is `null` or `true` but the permission to override is not granted,
         *                                    or if the binding is allowed to override, but does not conforms to it's overriding declaration.
         */
        private fun _checkOverrides(key: Kodein.Key, overrides: Boolean?) {
            val mustOverride = _overrideMode.must(overrides)

            if (mustOverride != null) {
                if (mustOverride && key !in _map)
                    throw Kodein.OverridingException("Binding $key must override an existing binding.")
                if (!mustOverride && key in _map)
                    throw Kodein.OverridingException("Binding $key must not override an existing binding.")
            }
        }

        /**
         * Left part of the key-binding syntax (`bind(Kodein.Key(Kodein.Bind(type, tag), argType))`).
         *
         * @property key The key to bind.
         * @param overrides `true` if it must override, `false` if it must not, `null` if it can but is not required to.
         * @throws Kodein.OverridingException If this bindings overrides an existing binding and is not allowed to.
         */
        inner class KeyBinder internal constructor(val key: Kodein.Key, overrides: Boolean?) {
            init {
                _checkIsReified(key.bind, key.bind.type)
                _checkIsReified(key, key.argType)
                _checkOverrides(key, overrides)
            }

            /**
             * Binds the previously given key to the given factory.
             *
             * @param factory The factory to bind.
             */
            infix fun with(factory: FactoryBinding<*, Any>) {
                _map[key] = factory
            }
        }

        /**
         * Left part of the bind-binding syntax (`bind(Kodein.Bind(type, tag))`).
         *
         * @property bind The type and tag object that will compose the key to bind.
         * @property overrides `true` if it must override, `false` if it must not, `null` if it can but is not required to.
         */
        inner class BindBinder internal constructor(val bind: Kodein.Bind, val overrides: Boolean?) {
            init {
                _checkIsReified(bind, bind.type)
            }

            /**
             * Binds the previously given type & tag to the given factory.
             *
             * The bound type will be the [FactoryBinding.createdType].
             *
             * @param factory The factory to bind.
             * @throws Kodein.OverridingException If this bindings overrides an existing binding and is not allowed to.
             */
            infix fun with(factory: FactoryBinding<*, Any>) {
                _checkIsReified(factory, factory.argType)

                val key = Kodein.Key(bind, factory.argType)
                _checkOverrides(key, overrides)

                _map[key] = factory
            }
        }

        /**
         * Starts the binding of a given key.
         *
         * @param key The key to bind.
         * @param overrides Whether this bind **must**, **may** or **must not** override an existing binding.
         * @return The binder: call [KeyBinder.with]) on it to finish the binding syntax and register the binding.
         */
        fun bind(key: Kodein.Key, overrides: Boolean? = null): KeyBinder = KeyBinder(key, overrides)

        /**
         * Starts the binding of a given type and tag.
         *
         * @param bind The type and tag to bind.
         * @param overrides Whether this bind **must**, **may** or **must not** override an existing binding.
         * @return The binder: call [BindBinder.with]) on it to finish the binding syntax and register the binding.
         */
        fun bind(bind: Kodein.Bind, overrides: Boolean? = null): BindBinder = BindBinder(bind, overrides)

        /**
         * Checks whether the given overriding declaration is allowed.
         *
         * @param allowOverride The overriding declaration.
         * @throws Kodein.OverridingException If it is not allowed to bind.
         */
        private fun _checkMatch(allowOverride: Boolean) {
            if (!_overrideMode.isAllowed && allowOverride)
                throw Kodein.OverridingException("Overriding has been forbidden")
        }

        /**
         * Imports all bindings defined in the given [KodeinContainer] into this builder.
         *
         * Note that this preserves scopes, meaning that a singleton-bound in the container argument will continue to exist only once.
         * Both containers will share the same instance.
         *
         * @param container The container object to import.
         * @param allowOverride Whether this module is allowed to override existing bindings.
         *                      If it is not, overrides (even explicit) will throw an [Kodein.OverridingException].
         * @throws Kodein.OverridingException If this kodein overrides an existing binding and is not allowed to
         *                                    OR [allowOverride] is true while YOU don't have the permission to override.
         */
        fun extend(container: KodeinContainer, allowOverride: Boolean = false) {
            _checkMatch(allowOverride)
            if (allowOverride)
                _map.putAll(container.bindings)
            else
                container.bindings.forEach { bind(it.key) with it.value }
        }

        /**
         * Creates a sub builder that will register its bindings to the same map.
         *
         * @param allowOverride Whether or not the bindings defined by this builder or its imports are allowed to **explicitly** override existing bindings.
         * @param silentOverride Whether or not the bindings defined by this builder or its imports are allowed to **silently** override existing bindings.
         */
        fun subBuilder(allowOverride: Boolean = false, silentOverride: Boolean = false): Builder {
            _checkMatch(allowOverride)
            return Builder(allowOverride, silentOverride, _map)
        }
    }


}
