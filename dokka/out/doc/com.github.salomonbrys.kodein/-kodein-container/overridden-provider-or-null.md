[com.github.salomonbrys.kodein](../index.md) / [KodeinContainer](index.md) / [overriddenProviderOrNull](.)

# overriddenProviderOrNull

`open fun overriddenProviderOrNull(bind: `[`Bind`](../-kodein/-bind/index.md)`, overrideLevel: Int): `[`Provider`](../-provider.md)`<Any>?`

Retrieve an overridden provider for the given key at the given override level, if there is an overridden binding at that level.

### Parameters

`bind` - The key to look for.

`overrideLevel` - The override level.
Override level 0 means the first overridden factory (not the "active" binding).

### Exceptions

`Kodein.DependencyLoopException` - When calling the provider function, if the instance construction triggered a dependency loop.

**Return**
The overridden provider, or null if there was o binding overridden at that level.

