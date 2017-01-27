[com.github.salomonbrys.kodein](index.md) / [genericScopedSingleton](.)

# genericScopedSingleton

`inline fun <reified C, reified T : Any> `[`Builder`](-kodein/-builder/index.md)`.genericScopedSingleton(scope: `[`Scope`](-scope/index.md)`<C>, noinline creator: (`[`ProviderKodein`](-provider-kodein/index.md)`, C) -> T): `[`CScopedSingleton`](-c-scoped-singleton/index.md)`<C, T>`

Creates a scoped singleton factory, effectively a `factory { Scope -> T }`.

C &amp; T generics will be kept.

### Parameters

`C` - The scope context type.

`T` - The singleton type.

`scope` - The scope object in which the singleton will be stored.

`creator` - A function that creates the singleton object. Will be called only if the singleton does not already exist in the scope.