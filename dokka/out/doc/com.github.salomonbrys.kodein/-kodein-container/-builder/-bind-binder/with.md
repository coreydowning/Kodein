[com.github.salomonbrys.kodein](../../../index.md) / [KodeinContainer](../../index.md) / [Builder](../index.md) / [BindBinder](index.md) / [with](.)

# with

`infix fun with(factory: `[`FactoryBinding`](../../../-factory-binding/index.md)`<*, Any>): Unit`

Binds the previously given type &amp; tag to the given factory.

The bound type will be the [FactoryBinding.createdType](../../../-factory-binding/created-type.md).

### Parameters

`factory` - The factory to bind.

### Exceptions

`Kodein.OverridingException` - If this bindings overrides an existing binding and is not allowed to.