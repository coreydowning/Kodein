[com.github.salomonbrys.kodein](../index.md) / [SequenceProviderKodein](.)

# SequenceProviderKodein

`interface SequenceProviderKodein<T> : `[`ProviderKodein`](../-provider-kodein/index.md)

Allows a coroutine to generate a sequence AND access transitive dependencies.

### Parameters

`T` - The type of instance of the bind.

### Functions

| Name | Summary |
|---|---|
| [yield](yield.md) | `abstract suspend fun yield(value: T): Unit`<br>Yields this value as the next instance. |
| [yieldAll](yield-all.md) | `abstract suspend fun yieldAll(iterator: Iterator<T>): Unit`<br>`abstract suspend fun yieldAll(elements: Iterable<T>): Unit`<br>`abstract suspend fun yieldAll(sequence: <ERROR CLASS><T>): Unit`<br>Yields these values as the next instances. |

### Inherited Functions

| Name | Summary |
|---|---|
| [overriddenInstance](../-provider-kodein/overridden-instance.md) | `abstract fun <T : Any> overriddenInstance(): T`<br>Gets an instance from the overridden binding. |
| [overriddenInstanceOrNull](../-provider-kodein/overridden-instance-or-null.md) | `abstract fun <T : Any> overriddenInstanceOrNull(): T?`<br>Gets an instance from the overridden binding, if this binding overrides an existing binding. |
| [overriddenProvider](../-provider-kodein/overridden-provider.md) | `abstract fun <T : Any> overriddenProvider(): `[`Provider`](../-provider.md)`<T>`<br>Gets a provider from the overridden binding. |
| [overriddenProviderOrNull](../-provider-kodein/overridden-provider-or-null.md) | `abstract fun <T : Any> overriddenProviderOrNull(): `[`Provider`](../-provider.md)`<T>?`<br>Gets a provider from the overridden binding, if this binding overrides an existing binding. |

### Extension Properties

| Name | Summary |
|---|---|
| [lazy](../lazy.md) | `val `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.lazy: `[`LazyKodein`](../-lazy-kodein/index.md)<br>Allows lazy retrieval from a [Kodein](../-kodein/index.md) or [KodeinAware](../-kodein-aware.md) object. |

### Extension Functions

| Name | Summary |
|---|---|
| [erasedFactory](../erased-factory.md) | `fun <A, T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.erasedFactory(tag: Any? = null): `[`Factory`](../-factory.md)`<A, T>`<br>Gets a factory of `T` for the given argument type, return type and tag. |
| [erasedFactoryOrNull](../erased-factory-or-null.md) | `fun <A, T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.erasedFactoryOrNull(tag: Any? = null): `[`Factory`](../-factory.md)`<A, T>?`<br>Gets a factory of `T` for the given argument type, return type and tag, or nul if none is found. |
| [erasedInstance](../erased-instance.md) | `fun <T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.erasedInstance(tag: Any? = null): T`<br>Gets an instance of `T` for the given type and tag. |
| [erasedInstanceOrNull](../erased-instance-or-null.md) | `fun <T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.erasedInstanceOrNull(tag: Any? = null): T?`<br>Gets an instance of `T` for the given type and tag, or null if none is found. |
| [erasedProvider](../erased-provider.md) | `fun <T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.erasedProvider(tag: Any? = null): `[`Provider`](../-provider.md)`<T>`<br>Gets a provider of `T` for the given type and tag. |
| [erasedProviderOrNull](../erased-provider-or-null.md) | `fun <T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.erasedProviderOrNull(tag: Any? = null): `[`Provider`](../-provider.md)`<T>?`<br>Gets a provider of `T` for the given type and tag, or null if none is found. |
| [genericFactory](../generic-factory.md) | `fun <A, T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.genericFactory(tag: Any? = null): `[`Factory`](../-factory.md)`<A, T>`<br>Gets a factory of `T` for the given argument type, return type and tag. |
| [genericFactoryOrNull](../generic-factory-or-null.md) | `fun <A, T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.genericFactoryOrNull(tag: Any? = null): `[`Factory`](../-factory.md)`<A, T>?`<br>Gets a factory of `T` for the given argument type, return type and tag, or nul if none is found. |
| [genericInstance](../generic-instance.md) | `fun <T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.genericInstance(tag: Any? = null): T`<br>Gets an instance of `T` for the given type and tag. |
| [genericInstanceOrNull](../generic-instance-or-null.md) | `fun <T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.genericInstanceOrNull(tag: Any? = null): T?`<br>Gets an instance of `T` for the given type and tag, or null if none is found. |
| [genericProvider](../generic-provider.md) | `fun <T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.genericProvider(tag: Any? = null): `[`Provider`](../-provider.md)`<T>`<br>Gets a provider of `T` for the given type and tag. |
| [genericProviderOrNull](../generic-provider-or-null.md) | `fun <T : Any> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.genericProviderOrNull(tag: Any? = null): `[`Provider`](../-provider.md)`<T>?`<br>Gets a provider of `T` for the given type and tag, or null if none is found. |
| [with](../with.md) | `fun <A> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.with(arg: () -> A): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<A>`<br>`fun <A> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.with(arg: A): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<A>`<br>Allows to get a provider or an instance from a curried factory with an `A` argument. |
| [with](../../com.github.salomonbrys.kodein.erased/with.md) | `fun <A> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.with(arg: () -> A): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<A>`<br>`fun <A> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.with(arg: A): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<A>`<br>Allows to get a provider or an instance from a curried factory with an `A` argument. |
| [withClassOf](../with-class-of.md) | `fun <T : Any> `[`Kodein`](../-kodein/index.md)`.withClassOf(of: T): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Allows to get a provider or an instance from a curried factory with a `Class` argument. |
| [withErased](../with-erased.md) | `fun <A> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.withErased(arg: () -> A): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<A>`<br>`fun <A> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.withErased(arg: A): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<A>`<br>Allows to get a provider or an instance from a curried factory with an `A` argument. |
| [withGeneric](../with-generic.md) | `fun <A> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.withGeneric(arg: () -> A): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<A>`<br>`fun <A> `[`KodeinAwareBase`](../-kodein-aware-base/index.md)`.withGeneric(arg: A): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<A>`<br>Allows to get a provider or an instance from a curried factory with an `A` argument. |
| [withKClassOf](../with-k-class-of.md) | `fun <T : Any> `[`Kodein`](../-kodein/index.md)`.withKClassOf(of: T): `[`CurriedKodeinFactory`](../-curried-kodein-factory/index.md)`<KClass<*>>`<br>Allows to get a provider or an instance from a curried factory with a `Class` argument. |
