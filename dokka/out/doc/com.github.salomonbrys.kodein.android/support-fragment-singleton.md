[com.github.salomonbrys.kodein.android](index.md) / [supportFragmentSingleton](.)

# supportFragmentSingleton

`inline fun <reified T : Any> `[`Builder`](../com.github.salomonbrys.kodein/-kodein/-builder/index.md)`.~~supportFragmentSingleton~~(noinline creator: (`[`Kodein`](../com.github.salomonbrys.kodein/-kodein/index.md)`, Fragment) -> T): `[`FactoryBinding`](../com.github.salomonbrys.kodein/-factory-binding/index.md)`<Fragment, T>`
**Deprecated:** Use scopedSingleton instead.

Creates a support fragment scoped singleton factory, effectively a `factory { Fragment -> T }`.

### Parameters

`T` - The singleton type.

`creator` - A function that creates the singleton object. Will be called only if the singleton does not already exist for the support fragment argument.

**Return**
The factory to bind.

