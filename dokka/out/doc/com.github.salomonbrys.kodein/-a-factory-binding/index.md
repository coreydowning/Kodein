[com.github.salomonbrys.kodein](../index.md) / [AFactoryBinding](.)

# AFactoryBinding

`abstract class AFactoryBinding<in A, out T : Any> : `[`FactoryBinding`](../-factory-binding/index.md)`<A, T>`

FactoryBinding base.

Enables sub-classes to implement only [FactoryBinding.getInstance](../-factory-binding/get-instance.md).

### Parameters

`A` - The factory argument type.

`T` - The created type.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AFactoryBinding(factoryName: String, argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, createdType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`)`<br>FactoryBinding base. |

### Properties

| Name | Summary |
|---|---|
| [argType](arg-type.md) | `open val argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>The type of the argument this factory will function for. |
| [createdType](created-type.md) | `open val createdType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>The type of object that is created by this factory. |
| [description](description.md) | `open val description: String`<br>The description of this factory (using simple type names), *used for debug print only*. |
| [factoryName](factory-name.md) | `open val factoryName: String`<br>The name of this factory, *used for debug print only*. |
| [fullDescription](full-description.md) | `open val fullDescription: String`<br>The description of this factory (using full type names), *used for debug print only*. |
