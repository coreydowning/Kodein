[com.github.salomonbrys.kodein](../index.md) / [AProviderBinding](.)

# AProviderBinding

`abstract class AProviderBinding<out T : Any> : `[`ProviderBinding`](../-provider-binding/index.md)`<T>`

Provider base.

A provider is like a [AFactoryBinding](../-a-factory-binding/index.md), but without argument (the [FactoryBinding](../-factory-binding/index.md) is registered with a `Unit` argument).

### Parameters

`T` - The created type.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AProviderBinding(factoryName: String, createdType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`)`<br>Provider base. |

### Properties

| Name | Summary |
|---|---|
| [argType](arg-type.md) | `open val argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>The type of the argument this factory will function for. |
| [createdType](created-type.md) | `open val createdType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>The type of object that is created by this factory. |
| [description](description.md) | `open val description: String`<br>The description of this factory (using simple type names), *used for debug print only*. |
| [factoryName](factory-name.md) | `open val factoryName: String`<br>The name of this factory, *used for debug print only*. |
| [fullDescription](full-description.md) | `open val fullDescription: String`<br>The description of this factory (using full type names), *used for debug print only*. |

### Inherited Functions

| Name | Summary |
|---|---|
| [getInstance](../-provider-binding/get-instance.md) | `abstract fun getInstance(kodein: `[`ProviderKodein`](../-provider-kodein/index.md)`, key: `[`Key`](../-kodein/-key/index.md)`): T`<br>Get an instance of type `T`.`open fun getInstance(kodein: `[`FactoryKodein`](../-factory-kodein/index.md)`, key: `[`Key`](../-kodein/-key/index.md)`, arg: Unit): T`<br>Get an instance of type `T` function argument `A`. |
