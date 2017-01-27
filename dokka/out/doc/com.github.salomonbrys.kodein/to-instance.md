[com.github.salomonbrys.kodein](index.md) / [toInstance](.)

# toInstance

`inline fun <A, T : Any> <ERROR CLASS><`[`Factory`](-factory.md)`<A, T>>.toInstance(crossinline arg: () -> A): <ERROR CLASS><T>`

Transforms a lazy factory property into a lazy instance property by currying the factory argument.

### Parameters

`A` - The type of argument the factory held by this property takes.

`T` - The type of object to retrieve with the factory held by this property.

`arg` - A function that provides the argument that will be passed to the factory.

**Receiver**
The factory to curry.

**Return**
A property that yields an instance of `T`.

`inline fun <A, T : Any> <ERROR CLASS><`[`Factory`](-factory.md)`<A, T>?>.toInstance(crossinline arg: () -> A): <ERROR CLASS><T?>`

Transforms a lazy nullable factory property into a lazy nullable instance property by currying the factory argument.

### Parameters

`A` - The type of argument the factory held by this property takes.

`T` - The type of object to retrieve with the factory held by this property.

`arg` - A function that provides the argument that will be passed to the factory.

**Receiver**
The factory to curry.

**Return**
A property that yields an instance of `T`, or null if no factory was found.

`inline fun <A, T : Any> `[`InjectedProperty`](-injected-property/index.md)`<`[`Factory`](-factory.md)`<A, T>>.toInstance(crossinline arg: () -> A): <ERROR CLASS><T>`
`inline fun <A, T : Any> `[`InjectedProperty`](-injected-property/index.md)`<`[`Factory`](-factory.md)`<A, T>?>.toInstance(crossinline arg: () -> A): <ERROR CLASS><T?>`

Transforms an injected factory property into an injected instance property by currying the factory with the given argument.

### Parameters

`A` - The type of argument the factory takes.

`T` - The type of object to retrieve.

`arg` - A function that provides the argument that will be passed to the factory.

**Receiver**
The injected factory to curry.

**Return**
An injected instance property that, when injected, will call the receiver factory with the given argument.

