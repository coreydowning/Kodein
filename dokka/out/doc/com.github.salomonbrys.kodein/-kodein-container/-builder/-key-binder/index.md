[com.github.salomonbrys.kodein](../../../index.md) / [KodeinContainer](../../index.md) / [Builder](../index.md) / [KeyBinder](.)

# KeyBinder

`inner class KeyBinder : Any`

Left part of the key-binding syntax (`bind(Kodein.Key(Kodein.Bind(type, tag), argType))`).

### Properties

| Name | Summary |
|---|---|
| [key](key.md) | `val key: `[`Key`](../../../-kodein/-key/index.md)<br>The key to bind. |

### Functions

| Name | Summary |
|---|---|
| [with](with.md) | `infix fun with(factory: `[`FactoryBinding`](../../../-factory-binding/index.md)`<*, Any>): Unit`<br>Binds the previously given key to the given factory. |
