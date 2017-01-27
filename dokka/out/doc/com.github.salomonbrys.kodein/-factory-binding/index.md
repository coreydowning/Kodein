[com.github.salomonbrys.kodein](../index.md) / [FactoryBinding](.)

# FactoryBinding

`interface FactoryBinding<in A, out T : Any> : Any`

Base class that knows how to get an instance.

All bindings are bound to a FactoryBinding.
Whether this factory creates a new instance at each call or not is left to implementation.

### Parameters

`A` - The type of argument used to create or retrieve an instance.

`T` - The type of instance this factory creates or retrieves.

### Properties

| Name | Summary |
|---|---|
| [argType](arg-type.md) | `abstract val argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>The type of the argument this factory will function for. |
| [createdType](created-type.md) | `abstract val createdType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>The type of object that is created by this factory. |
| [description](description.md) | `abstract val description: String`<br>The description of this factory (using simple type names), *used for debug print only*. |
| [factoryName](factory-name.md) | `abstract val factoryName: String`<br>The name of this factory, *used for debug print only*. |
| [fullDescription](full-description.md) | `abstract val fullDescription: String`<br>The description of this factory (using full type names), *used for debug print only*. |

### Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | `abstract fun getInstance(kodein: `[`FactoryKodein`](../-factory-kodein/index.md)`, key: `[`Key`](../-kodein/-key/index.md)`, arg: A): T`<br>Get an instance of type `T` function argument `A`. |

### Inheritors

| Name | Summary |
|---|---|
| [AFactoryBinding](../-a-factory-binding/index.md) | `abstract class AFactoryBinding<in A, out T : Any> : FactoryBinding<A, T>`<br>FactoryBinding base. |
| [AScoped](../-a-scoped/index.md) | `abstract class AScoped<in A, out C, out T : Any> : FactoryBinding<A, T>`<br>A factory to bind a type and tag into a [Scope](../-scope/index.md) or an [AutoScope](../-auto-scope/index.md). |
| [ProviderBinding](../-provider-binding/index.md) | `interface ProviderBinding<out T : Any> : FactoryBinding<Unit, T>` |
