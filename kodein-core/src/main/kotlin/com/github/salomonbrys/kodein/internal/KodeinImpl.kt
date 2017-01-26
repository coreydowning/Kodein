package com.github.salomonbrys.kodein.internal

import com.github.salomonbrys.kodein.*
import java.util.*

/**
 * Kodein implementation.
 *
 * Contains almost nothing because the Kodein object itself contains very few logic.
 * Everything is delegated wither to [typed] or to [container].
 */
internal open class KodeinImpl internal constructor(final override val container: KodeinContainer) : Kodein {

    /**
     * Creates a Kodein object with a [Kodein.Builder]'s internal.
     *
     * - Uses the [KodeinContainer.Builder] to create the [container].
     * - Calls all callbacks registered in [Kodein.Builder._callbacks].
     *
     * @param builder The builder to use.
     */
    @Suppress("unused")
    private constructor(builder: Kodein.Builder) : this(KodeinContainerImpl(builder.container)) {
        builder._callbacks.forEach { it() }
        builder._factoryCallbacks.forEach { it.second.invoke(FactoryKodeinImpl(container, it.first, 0)) }
    }

    /**
     * "Main" constructor.
     */
    constructor(allowSilentOverride: Boolean = false, init: Kodein.Builder.() -> Unit) : this(Kodein.Builder(KodeinContainer.Builder(true, allowSilentOverride, CMap()), ArrayList(), ArrayList(), init))

    override val typed = TKodein(container)
}

@Suppress("UNCHECKED_CAST")
internal open class FactoryKodeinImpl internal constructor(container: KodeinContainer, private val _key: Kodein.Key, private val _overrideLevel: Int) : KodeinImpl(container), FactoryKodein {
    override fun <A, T : Any> overriddenFactory(): Factory<A, T> = container.overriddenNonNullFactory(_key, _overrideLevel) as Factory<A, T>
    override fun <A, T : Any> overriddenFactoryOrNull(): Factory<A, T>? = container.overriddenFactoryOrNull(_key, _overrideLevel) as Factory<A, T>?
}