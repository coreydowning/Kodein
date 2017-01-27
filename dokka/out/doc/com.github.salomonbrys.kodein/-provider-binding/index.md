[com.github.salomonbrys.kodein](../index.md) / [ProviderBinding](.)

# ProviderBinding

`interface ProviderBinding<out T : Any> : `[`FactoryBinding`](../-factory-binding/index.md)`<Unit, T>`

### Inherited Properties

| Name | Summary |
|---|---|
| [argType](../-factory-binding/arg-type.md) | `abstract val argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>The type of the argument this factory will function for. |
| [createdType](../-factory-binding/created-type.md) | `abstract val createdType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>The type of object that is created by this factory. |
| [description](../-factory-binding/description.md) | `abstract val description: String`<br>The description of this factory (using simple type names), *used for debug print only*. |
| [factoryName](../-factory-binding/factory-name.md) | `abstract val factoryName: String`<br>The name of this factory, *used for debug print only*. |
| [fullDescription](../-factory-binding/full-description.md) | `abstract val fullDescription: String`<br>The description of this factory (using full type names), *used for debug print only*. |

### Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | `abstract fun getInstance(kodein: `[`ProviderKodein`](../-provider-kodein/index.md)`, key: `[`Key`](../-kodein/-key/index.md)`): T`<br>Get an instance of type `T`.`open fun getInstance(kodein: `[`FactoryKodein`](../-factory-kodein/index.md)`, key: `[`Key`](../-kodein/-key/index.md)`, arg: Unit): T`<br>Get an instance of type `T` function argument `A`. |

### Inheritors

| Name | Summary |
|---|---|
| [AProviderBinding](../-a-provider-binding/index.md) | `abstract class AProviderBinding<out T : Any> : ProviderBinding<T>`<br>Provider base. |
