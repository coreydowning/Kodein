[com.github.salomonbrys.kodein](../../../index.md) / [KodeinContainer](../../index.md) / [Builder](../index.md) / [BindBinder](.)

# BindBinder

`inner class BindBinder : Any`

Left part of the bind-binding syntax (`bind(Kodein.Bind(type, tag))`).

### Properties

| Name | Summary |
|---|---|
| [bind](bind.md) | `val bind: `[`Bind`](../../../-kodein/-bind/index.md)<br>The type and tag object that will compose the key to bind. |
| [overrides](overrides.md) | `val overrides: Boolean?`<br>`true` if it must override, `false` if it must not, `null` if it can but is not required to. |

### Functions

| Name | Summary |
|---|---|
| [with](with.md) | `infix fun with(factory: `[`FactoryBinding`](../../../-factory-binding/index.md)`<*, Any>): Unit`<br>Binds the previously given type &amp; tag to the given factory. |
