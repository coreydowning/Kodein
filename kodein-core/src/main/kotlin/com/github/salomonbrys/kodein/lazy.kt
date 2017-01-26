package com.github.salomonbrys.kodein

import java.lang.reflect.Type

/**
 * Base [LazyKodeinAware] interface.
 *
 * It is separate from [LazyKodeinAware] because [LazyKodein] implements itself [LazyKodeinAwareBase] but not [LazyKodeinAware].<br />
 * This is because there are some extension functions to [LazyKodeinAware] that would not make sense applied to the [LazyKodein] object.<br />
 * For example, [LazyKodeinAware.withClass], if applied to [LazyKodein], would create a very un-expected result.
 */
interface LazyKodeinAwareBase {
    /**
     * A Lazy Kodein Aware class must be within reach of a LazyKodein object.
     */
    val kodein: LazyKodein
}

/**
 * Allows lazy retrieval from a [Kodein] or [KodeinAware] object.
 */
val KodeinAwareBase.lazy: LazyKodein get() = LazyKodein(lazy { kodein })

/**
 * An object that wraps a Kodein `Lazy` object and acts both as a `Lazy` property delegate & a function.
 *
 * @param k The lazy property delegate to wrap.
 */
class LazyKodein(k: Lazy<Kodein>) : Lazy<Kodein> by k, () -> Kodein, LazyKodeinAwareBase {
    override val kodein: LazyKodein get() = this

    /**
     * @return The kodein object to use.
     *
     * Calling this for the first time will effectively construct the kodein object.
     */
    override fun invoke(): Kodein = value

    /**
     * Constructor with a function (will `lazify` the function).
     *
     * @param f A function that returns a Kodein. Guaranteed to be called only once.
     */
    constructor(f: () -> Kodein) : this(lazy(f))
}

/**
 * You can use the result of this function as a property delegate *or* as a function.
 *
 * @param f The function to get a Kodein, guaranteed to be called only once.
 */
fun Kodein.Companion.lazy(allowSilentOverride: Boolean = false, f: Kodein.Builder.() -> Unit): LazyKodein = LazyKodein(kotlin.lazy { invoke(allowSilentOverride, f) })



/**
 * Gets a lazy factory for the given type, tag and argument type.
 *
 * A & T generics will be kept.
 *
 * @param A The type of argument the factory held by this property takes.
 * @param T The type of object to retrieve with the factory held by this property.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a factory of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no factory was found.
 * @throws Kodein.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A, reified T : Any> LazyKodeinAwareBase.genericFactory(tag: Any? = null) : Lazy<Factory<A, T>> = lazy { kodein().genericFactory<A, T>(tag) }

/**
 * Gets a lazy factory for the given type, tag and argument type.
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the factory held by this property takes.
 * @param T The type of object to retrieve with the factory held by this property.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a factory of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no factory was found.
 * @throws Kodein.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A, reified T : Any> LazyKodeinAwareBase.erasedFactory(tag: Any? = null) : Lazy<Factory<A, T>> = lazy { kodein().erasedFactory<A, T>(tag) }

/**
 * Gets a lazy factory for the given type, tag and argument type, or null if none is found.
 *
 * A & T generics will be kept.
 *
 * @param A The type of argument the factory held by this property takes.
 * @param T The type of object to retrieve with the factory held by this property.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a factory of `T`, or null if no factory was found.
 * @throws Kodein.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A, reified T : Any> LazyKodeinAwareBase.genericFactoryOrNull(tag: Any? = null) : Lazy<Factory<A, T>?> = lazy { kodein().genericFactoryOrNull<A, T>(tag) }

/**
 * Gets a lazy factory for the given type, tag and argument type, or null if none is found.
 *
 * A & T generics will be erased!
 *
 * @param A The type of argument the factory held by this property takes.
 * @param T The type of object to retrieve with the factory held by this property.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a factory of `T`, or null if no factory was found.
 * @throws Kodein.DependencyLoopException When calling the factory, if the value construction triggered a dependency loop.
 */
inline fun <reified A, reified T : Any> LazyKodeinAwareBase.erasedFactoryOrNull(tag: Any? = null) : Lazy<Factory<A, T>?> = lazy { kodein().erasedFactoryOrNull<A, T>(tag) }

/**
 * Gets a lazy provider for the given type and tag.
 *
 * T generics will be kept.
 *
 * @param T The type of object to retrieve with the provider held by this property.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a provider of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no provider was found.
 * @throws Kodein.DependencyLoopException When calling the provider, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> LazyKodeinAwareBase.genericProvider(tag: Any? = null) : Lazy<Provider<T>> = lazy { kodein().genericProvider<T>(tag) }

/**
 * Gets a lazy provider for the given type and tag.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve with the provider held by this property.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a provider of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no provider was found.
 * @throws Kodein.DependencyLoopException When calling the provider, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> LazyKodeinAwareBase.erasedProvider(tag: Any? = null) : Lazy<Provider<T>> = lazy { kodein().erasedProvider<T>(tag) }

/**
 * Gets a lazy provider for the given type and tag, or null if none is found.
 *
 * T generics will be kept.
 *
 * @param T The type of object to retrieve with the provider held by this property.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a provider of `T`, or null if no provider was found.
 * @throws Kodein.DependencyLoopException When calling the provider, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> LazyKodeinAwareBase.genericProviderOrNull(tag: Any? = null) : Lazy<Provider<T>?> = lazy { kodein().genericProviderOrNull<T>(tag) }

/**
 * Gets a lazy provider for the given type and tag, or null if none is found.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve with the provider held by this property.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a provider of `T`, or null if no provider was found.
 * @throws Kodein.DependencyLoopException When calling the provider, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> LazyKodeinAwareBase.erasedProviderOrNull(tag: Any? = null) : Lazy<Provider<T>?> = lazy { kodein().erasedProviderOrNull<T>(tag) }

/**
 * Gets a lazy instance for the given type and tag.
 *
 * T generics will be kept.
 *
 * @param T The type of object to retrieve.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields an instance of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no provider was found.
 * @throws Kodein.DependencyLoopException When accessing the property, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> LazyKodeinAwareBase.genericInstance(tag: Any? = null) : Lazy<T> = lazy { kodein().genericInstance<T>(tag) }

/**
 * Gets a lazy instance for the given type and tag.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields an instance of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no provider was found.
 * @throws Kodein.DependencyLoopException When accessing the property, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> LazyKodeinAwareBase.erasedInstance(tag: Any? = null) : Lazy<T> = lazy { kodein().erasedInstance<T>(tag) }

/**
 * Gets a lazy instance for the given type and tag, or null is none is found.
 *
 * T generics will be kept.
 *
 * @param T The type of object to retrieve.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields an instance of `T`, or null if no provider is found.
 * @throws Kodein.DependencyLoopException When accessing the property, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> LazyKodeinAwareBase.genericInstanceOrNull(tag: Any? = null) : Lazy<T?> = lazy { kodein().genericInstanceOrNull<T>(tag) }

/**
 * Gets a lazy instance for the given type and tag, or null is none is found.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields an instance of `T`, or null if no provider is found.
 * @throws Kodein.DependencyLoopException When accessing the property, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> LazyKodeinAwareBase.erasedInstanceOrNull(tag: Any? = null) : Lazy<T?> = lazy { kodein().erasedInstanceOrNull<T>(tag) }

/**
 * Allows to get a lazy provider or instance from a lazy factory with a curried argument.
 *
 * @param A The type of argument that the factory takes.
 * @property kodein The Kodein provider to use for retrieval.
 * @property arg The argument to provide to the factory when retrieving values.
 * @property argType The type of argument that the factory takes.
 */
class CurriedLazyKodeinFactory<out A>(val kodein: () -> Kodein, val arg: () -> A, val argType: Type)

/**
 * Gets a lazy provider of `T` for the given tag from a curried factory with an `A` argument.
 *
 * T generics will be kept.
 *
 * @param T The type of object to retrieve with the provider held by this property.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a provider of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no factory was found.
 * @throws Kodein.DependencyLoopException When calling the provider, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> CurriedLazyKodeinFactory<*>.genericProvider(tag: Any? = null): Lazy<Provider<T>> = lazy { kodein().typed.factory(argType, genericToken<T>(), tag) } .toProvider(arg)

/**
 * Gets a lazy provider of `T` for the given tag from a curried factory with an `A` argument.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve with the provider held by this property.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a provider of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no factory was found.
 * @throws Kodein.DependencyLoopException When calling the provider, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> CurriedLazyKodeinFactory<*>.erasedProvider(tag: Any? = null): Lazy<Provider<T>> = lazy { kodein().typed.factory(argType, T::class.java, tag) } .toProvider(arg)

/**
 * Gets a lazy provider of `T` for the given tag from a curried factory with an `A` argument, or null if none is found.
 *
 * T generics will be kept.
 *
 * @param T The type of object to retrieve with the provider held by this property.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a provider of `T`, or null if no factory is found.
 * @throws Kodein.DependencyLoopException When calling the provider, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> CurriedLazyKodeinFactory<*>.genericProviderOrNull(tag: Any? = null): Lazy<Provider<T>?> = lazy { kodein().typed.factoryOrNull(argType, genericToken<T>(), tag) } .toProvider(arg)

/**
 * Gets a lazy provider of `T` for the given tag from a curried factory with an `A` argument, or null if none is found.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve with the provider held by this property.
 * @param tag The bound tag, if any.
 * @return A lazy property that yields a provider of `T`, or null if no factory is found.
 * @throws Kodein.DependencyLoopException When calling the provider, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> CurriedLazyKodeinFactory<*>.erasedProviderOrNull(tag: Any? = null): Lazy<Provider<T>?> = lazy { kodein().typed.factoryOrNull(argType, T::class.java, tag) } .toProvider(arg)

/**
 * Gets a lazy instance of `T` for the given tag from a curried factory with an `A` argument.
 *
 * T generics will be kept.
 *
 * @param T The type of object to retrieve.
 * @param tag The bound tag, if any.
 * @return A lazy instance of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no factory was found.
 * @throws Kodein.DependencyLoopException When accessing the property, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> CurriedLazyKodeinFactory<*>.genericInstance(tag: Any? = null): Lazy<T> = lazy { kodein().typed.factory(argType, genericToken<T>(), tag) } .toInstance(arg)

/**
 * Gets a lazy instance of `T` for the given tag from a curried factory with an `A` argument.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve.
 * @param tag The bound tag, if any.
 * @return A lazy instance of `T`.
 * @throws Kodein.NotFoundException When accessing the property, if no factory was found.
 * @throws Kodein.DependencyLoopException When accessing the property, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> CurriedLazyKodeinFactory<*>.erasedInstance(tag: Any? = null): Lazy<T> = lazy { kodein().typed.factory(argType, T::class.java, tag) } .toInstance(arg)

/**
 * Gets a lazy instance of `T` for the given tag from a curried factory with an `A` argument, or null if none is found.
 *
 * T generics will be kept.
 *
 * @param T The type of object to retrieve.
 * @param tag The bound tag, if any.
 * @return A lazy instance of `T`, or null if no factory was found.
 * @throws Kodein.DependencyLoopException When accessing the property, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> CurriedLazyKodeinFactory<*>.genericInstanceOrNull(tag: Any? = null): Lazy<T?> = lazy { kodein().typed.factoryOrNull(argType, genericToken<T>(), tag) } .toInstance(arg)

/**
 * Gets a lazy instance of `T` for the given tag from a curried factory with an `A` argument, or null if none is found.
 *
 * T generics will be erased!
 *
 * @param T The type of object to retrieve.
 * @param tag The bound tag, if any.
 * @return A lazy instance of `T`, or null if no factory was found.
 * @throws Kodein.DependencyLoopException When accessing the property, if the value construction triggered a dependency loop.
 */
inline fun <reified T : Any> CurriedLazyKodeinFactory<*>.erasedInstanceOrNull(tag: Any? = null): Lazy<T?> = lazy { kodein().typed.factoryOrNull(argType, T::class.java, tag) } .toInstance(arg)


/**
 * Allows to get a lazy provider or instance from a curried factory with an `A` argument.
 *
 * A generics will be kept.
 *
 * @param A The type of argument the factory takes.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param arg A function that provides the argument that will be passed to the factory.
 * @return An object from which you can get an instance or a provider.
 */
inline fun <reified A> LazyKodeinAwareBase.withGeneric(noinline arg: () -> A): CurriedLazyKodeinFactory<A> = CurriedLazyKodeinFactory(kodein, arg, genericToken<A>().type)

/**
 * Allows to get a lazy provider or instance from a curried factory with an `A` argument.
 *
 * A generics will be erased!
 *
 * @param A The type of argument the factory takes.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param arg A function that provides the argument that will be passed to the factory.
 * @return An object from which you can get an instance or a provider.
 */
inline fun <reified A> LazyKodeinAwareBase.withErased(noinline arg: () -> A): CurriedLazyKodeinFactory<A> = CurriedLazyKodeinFactory(kodein, arg, typeClass<A>())

/**
 * Allows to get a lazy provider or instance from a curried factory with an `A` argument.
 *
 * A generics will be kept.
 *
 * @param A The type of argument the factory takes.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param arg The argument that will be passed to the factory.
 * @return An object from which you can get an instance or a provider.
 */
inline fun <reified A> LazyKodeinAwareBase.withGeneric(arg: A): CurriedLazyKodeinFactory<A> = withGeneric { arg }

/**
 * Allows to get a lazy provider or instance from a curried factory with an `A` argument.
 *
 * A generics will be kept.
 *
 * @param A The type of argument the factory takes.
 * @receiver Either a [LazyKodein] instance or a [LazyKodeinAware] class.
 * @param arg The argument that will be passed to the factory.
 * @return An object from which you can get an instance or a provider.
 */
inline fun <reified A> LazyKodeinAwareBase.withErased(arg: A): CurriedLazyKodeinFactory<A> = withErased { arg }

/**
 * Allows lazy retrieval.
 *
 * Example: `val manager: Manager by withClass().lazy.instance()`
 *
 * @param A The type of argument to pass to the curried factory.
 */
val <A> CurriedKodeinFactory<A>.lazy: CurriedLazyKodeinFactory<A> get() = CurriedLazyKodeinFactory(kodein, arg, argType)



/**
 * Any class that extends this interface can use Kodein to "seamlessly" get lazy properties.
 */
interface LazyKodeinAware : LazyKodeinAwareBase



/**
 * Transforms a lazy factory property into a lazy provider property by currying the factory argument.
 *
 * @param A The type of argument the factory held by this property takes.
 * @param T The type of object to retrieve with the factory held by this property.
 * @receiver The factory to curry.
 * @param arg A function that provides the argument that will be passed to the factory.
 * @return A property that yields a provider of `T`.
 */
inline fun <A, T : Any> Lazy<Factory<A, T>>.toProvider(crossinline arg: () -> A): Lazy<Provider<T>> = lazy { { value(arg()) } }

/**
 * Transforms a lazy nullable factory property into a lazy nullable provider property by currying the factory argument.
 *
 * @param A The type of argument the factory held by this property takes.
 * @param T The type of object to retrieve with the factory held by this property.
 * @receiver The factory to curry.
 * @param arg A function that provides the argument that will be passed to the factory.
 * @return A property that yields a provider of `T`, or null if no factory was found.
 */
@JvmName("toNullableProvider")
inline fun <A, T : Any> Lazy<Factory<A, T>?>.toProvider(crossinline arg: () -> A): Lazy<Provider<T>?> = lazy { val factory = value ; if (factory != null) return@lazy { factory(arg()) } else return@lazy null }

/**
 * Transforms a lazy factory property into a lazy instance property by currying the factory argument.
 *
 * @param A The type of argument the factory held by this property takes.
 * @param T The type of object to retrieve with the factory held by this property.
 * @receiver The factory to curry.
 * @param arg A function that provides the argument that will be passed to the factory.
 * @return A property that yields an instance of `T`.
 */
inline fun <A, T : Any> Lazy<Factory<A, T>>.toInstance(crossinline arg: () -> A): Lazy<T> = lazy { value(arg()) }

/**
 * Transforms a lazy nullable factory property into a lazy nullable instance property by currying the factory argument.
 *
 * @param A The type of argument the factory held by this property takes.
 * @param T The type of object to retrieve with the factory held by this property.
 * @receiver The factory to curry.
 * @param arg A function that provides the argument that will be passed to the factory.
 * @return A property that yields an instance of `T`, or null if no factory was found.
 */
@JvmName("toNullableInstance")
inline fun <A, T : Any> Lazy<Factory<A, T>?>.toInstance(crossinline arg: () -> A): Lazy<T?> = lazy { val factory = value ; if (factory != null) factory(arg()) else null }
