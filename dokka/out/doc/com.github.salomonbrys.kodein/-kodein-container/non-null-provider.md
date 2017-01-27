[com.github.salomonbrys.kodein](../index.md) / [KodeinContainer](index.md) / [nonNullProvider](.)

# nonNullProvider

`open fun nonNullProvider(bind: `[`Bind`](../-kodein/-bind/index.md)`): `[`Provider`](../-provider.md)`<Any>`

Retrieve a provider for the given bind.

### Parameters

`bind` - The bind (type and tag) to look for.

### Exceptions

`Kodein.NotFoundException` - If no provider was found.

`Kodein.DependencyLoopException` - When calling the provider function, if the instance construction triggered a dependency loop.

**Return**
The found provider.

