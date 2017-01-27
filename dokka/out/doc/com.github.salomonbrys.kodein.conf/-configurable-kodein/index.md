[com.github.salomonbrys.kodein.conf](../index.md) / [ConfigurableKodein](.)

# ConfigurableKodein

`class ConfigurableKodein : `[`Kodein`](../../com.github.salomonbrys.kodein/-kodein/index.md)

A class that can be used to configure a kodein object and as a kodein object.

If you want it to be mutable, the [mutable](mutable.md) property needs to be set **before** any dependency retrieval.
The non-mutable configuration methods ([addImport](add-import.md), [addExtend](add-extend.md) &amp; [addConfig](add-config.md)) needs to happen **before** any dependency retrieval.

### Parameters

`mutable` - Whether this Kodein can be mutated.

`allowSilentOverride` - Whether added configurations block are allowed non-explicit overrides.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ConfigurableKodein(mutable: Boolean = false, allowSilentOverride: Boolean = false)`<br>A class that can be used to configure a kodein object and as a kodein object. |

### Properties

| Name | Summary |
|---|---|
| [canConfigure](can-configure.md) | `val canConfigure: Boolean`<br>Whether or not this Kodein can be configured (meaning that it has not been used for retrieval yet). |
| [mutable](mutable.md) | `var mutable: Boolean?`<br>Whether this ConfigurableKodein can be mutated. |

### Functions

| Name | Summary |
|---|---|
| [addConfig](add-config.md) | `fun addConfig(config: (`[`Builder`](../../com.github.salomonbrys.kodein/-kodein/-builder/index.md)`) -> Unit): Unit`<br>Adds a configuration to the bindings that will be applied when the Kodein is constructed. |
| [addExtend](add-extend.md) | `fun addExtend(kodein: `[`Kodein`](../../com.github.salomonbrys.kodein/-kodein/index.md)`, allowOverride: Boolean = false): Unit`<br>Adds the bindings of an existing kodein instance to the bindings that will be applied when the Kodein is constructed. |
| [addImport](add-import.md) | `fun addImport(module: `[`Module`](../../com.github.salomonbrys.kodein/-kodein/-module/index.md)`, allowOverride: Boolean = false): Unit`<br>Adds a module to the bindings that will be applied when the Kodein is constructed. |
| [clear](clear.md) | `fun clear(): Unit`<br>Clear all the bindings of the Kodein instance. Needs [mutable](mutable.md) to be true. |
| [getOrConstruct](get-or-construct.md) | `fun getOrConstruct(): `[`Kodein`](../../com.github.salomonbrys.kodein/-kodein/index.md)<br>Get the kodein instance if it has already been constructed, or construct it if not. |

### Extension Properties

| Name | Summary |
|---|---|
| [lazy](../../com.github.salomonbrys.kodein/lazy.md) | `val `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.lazy: `[`LazyKodein`](../../com.github.salomonbrys.kodein/-lazy-kodein/index.md)<br>Allows lazy retrieval from a [Kodein](../../com.github.salomonbrys.kodein/-kodein/index.md) or [KodeinAware](../../com.github.salomonbrys.kodein/-kodein-aware.md) object. |

### Extension Functions

| Name | Summary |
|---|---|
| [erasedFactory](../../com.github.salomonbrys.kodein/erased-factory.md) | `fun <A, T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.erasedFactory(tag: Any? = null): `[`Factory`](../../com.github.salomonbrys.kodein/-factory.md)`<A, T>`<br>Gets a factory of `T` for the given argument type, return type and tag. |
| [erasedFactoryOrNull](../../com.github.salomonbrys.kodein/erased-factory-or-null.md) | `fun <A, T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.erasedFactoryOrNull(tag: Any? = null): `[`Factory`](../../com.github.salomonbrys.kodein/-factory.md)`<A, T>?`<br>Gets a factory of `T` for the given argument type, return type and tag, or nul if none is found. |
| [erasedInstance](../../com.github.salomonbrys.kodein/erased-instance.md) | `fun <T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.erasedInstance(tag: Any? = null): T`<br>Gets an instance of `T` for the given type and tag. |
| [erasedInstanceOrNull](../../com.github.salomonbrys.kodein/erased-instance-or-null.md) | `fun <T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.erasedInstanceOrNull(tag: Any? = null): T?`<br>Gets an instance of `T` for the given type and tag, or null if none is found. |
| [erasedProvider](../../com.github.salomonbrys.kodein/erased-provider.md) | `fun <T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.erasedProvider(tag: Any? = null): `[`Provider`](../../com.github.salomonbrys.kodein/-provider.md)`<T>`<br>Gets a provider of `T` for the given type and tag. |
| [erasedProviderOrNull](../../com.github.salomonbrys.kodein/erased-provider-or-null.md) | `fun <T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.erasedProviderOrNull(tag: Any? = null): `[`Provider`](../../com.github.salomonbrys.kodein/-provider.md)`<T>?`<br>Gets a provider of `T` for the given type and tag, or null if none is found. |
| [genericFactory](../../com.github.salomonbrys.kodein/generic-factory.md) | `fun <A, T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.genericFactory(tag: Any? = null): `[`Factory`](../../com.github.salomonbrys.kodein/-factory.md)`<A, T>`<br>Gets a factory of `T` for the given argument type, return type and tag. |
| [genericFactoryOrNull](../../com.github.salomonbrys.kodein/generic-factory-or-null.md) | `fun <A, T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.genericFactoryOrNull(tag: Any? = null): `[`Factory`](../../com.github.salomonbrys.kodein/-factory.md)`<A, T>?`<br>Gets a factory of `T` for the given argument type, return type and tag, or nul if none is found. |
| [genericInstance](../../com.github.salomonbrys.kodein/generic-instance.md) | `fun <T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.genericInstance(tag: Any? = null): T`<br>Gets an instance of `T` for the given type and tag. |
| [genericInstanceOrNull](../../com.github.salomonbrys.kodein/generic-instance-or-null.md) | `fun <T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.genericInstanceOrNull(tag: Any? = null): T?`<br>Gets an instance of `T` for the given type and tag, or null if none is found. |
| [genericProvider](../../com.github.salomonbrys.kodein/generic-provider.md) | `fun <T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.genericProvider(tag: Any? = null): `[`Provider`](../../com.github.salomonbrys.kodein/-provider.md)`<T>`<br>Gets a provider of `T` for the given type and tag. |
| [genericProviderOrNull](../../com.github.salomonbrys.kodein/generic-provider-or-null.md) | `fun <T : Any> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.genericProviderOrNull(tag: Any? = null): `[`Provider`](../../com.github.salomonbrys.kodein/-provider.md)`<T>?`<br>Gets a provider of `T` for the given type and tag, or null if none is found. |
| [with](../../com.github.salomonbrys.kodein/with.md) | `fun <A> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.with(arg: () -> A): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<A>`<br>`fun <A> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.with(arg: A): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<A>`<br>Allows to get a provider or an instance from a curried factory with an `A` argument. |
| [with](../../com.github.salomonbrys.kodein.erased/with.md) | `fun <A> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.with(arg: () -> A): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<A>`<br>`fun <A> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.with(arg: A): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<A>`<br>Allows to get a provider or an instance from a curried factory with an `A` argument. |
| [withClassOf](../../com.github.salomonbrys.kodein/with-class-of.md) | `fun <T : Any> `[`Kodein`](../../com.github.salomonbrys.kodein/-kodein/index.md)`.withClassOf(of: T): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Allows to get a provider or an instance from a curried factory with a `Class` argument. |
| [withErased](../../com.github.salomonbrys.kodein/with-erased.md) | `fun <A> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.withErased(arg: () -> A): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<A>`<br>`fun <A> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.withErased(arg: A): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<A>`<br>Allows to get a provider or an instance from a curried factory with an `A` argument. |
| [withGeneric](../../com.github.salomonbrys.kodein/with-generic.md) | `fun <A> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.withGeneric(arg: () -> A): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<A>`<br>`fun <A> `[`KodeinAwareBase`](../../com.github.salomonbrys.kodein/-kodein-aware-base/index.md)`.withGeneric(arg: A): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<A>`<br>Allows to get a provider or an instance from a curried factory with an `A` argument. |
| [withKClassOf](../../com.github.salomonbrys.kodein/with-k-class-of.md) | `fun <T : Any> `[`Kodein`](../../com.github.salomonbrys.kodein/-kodein/index.md)`.withKClassOf(of: T): `[`CurriedKodeinFactory`](../../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md)`<KClass<*>>`<br>Allows to get a provider or an instance from a curried factory with a `Class` argument. |
