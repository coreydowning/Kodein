[com.github.salomonbrys.kodein](../index.md) / [KodeinContainer](index.md) / [overriddenFactoryOrNull](.)

# overriddenFactoryOrNull

`abstract fun overriddenFactoryOrNull(key: `[`Key`](../-kodein/-key/index.md)`, overrideLevel: Int): `[`Factory`](../-factory.md)`<Any?, Any>?`

Retrieve an overridden factory for the given key at the given override level, if there is an overridden binding at that level.

### Parameters

`key` - The key to look for.

`overrideLevel` - The override level.
Override level 0 means the first overridden factory (not the "active" binding).

### Exceptions

`Kodein.DependencyLoopException` - When calling the factory function, if the instance construction triggered a dependency loop.

**Return**
The overridden factory, or null if there was o binding overridden at that level.

