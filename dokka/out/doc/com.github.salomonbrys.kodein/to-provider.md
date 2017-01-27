[com.github.salomonbrys.kodein](index.md) / [toProvider](.)

# toProvider

`inline fun <A, T : Any> <ERROR CLASS><`[`Factory`](-factory.md)`<A, T>>.toProvider(crossinline arg: () -> A): <ERROR CLASS><`[`Provider`](-provider.md)`<T>>`

Transforms a lazy factory property into a lazy provider property by currying the factory argument.

### Parameters

`A` - The type of argument the factory held by this property takes.

`T` - The type of object to retrieve with the factory held by this property.

`arg` - A function that provides the argument that will be passed to the factory.

**Receiver**
The factory to curry.

**Return**
A property that yields a provider of `T`.

`inline fun <A, T : Any> <ERROR CLASS><`[`Factory`](-factory.md)`<A, T>?>.toProvider(crossinline arg: () -> A): <ERROR CLASS><`[`Provider`](-provider.md)`<T>?>`

Transforms a lazy nullable factory property into a lazy nullable provider property by currying the factory argument.

### Parameters

`A` - The type of argument the factory held by this property takes.

`T` - The type of object to retrieve with the factory held by this property.

`arg` - A function that provides the argument that will be passed to the factory.

**Receiver**
The factory to curry.

**Return**
A property that yields a provider of `T`, or null if no factory was found.

`inline fun <A, T : Any> `[`InjectedProperty`](-injected-property/index.md)`<`[`Factory`](-factory.md)`<A, T>>.toProvider(crossinline arg: () -> A): <ERROR CLASS><`[`Provider`](-provider.md)`<T>>`

Transforms an injected factory property into an injected provider property by currying the factory with the given argument.

### Parameters

`A` - The type of argument the factory takes.

`T` - The type of object to retrieve.

`arg` - A function that provides the argument that will be passed to the factory.

**Receiver**
The injected factory to curry.

**Return**
An injected provider property that, when called, will call the receiver factory with the given argument.

`inline fun <A, T : Any> `[`InjectedProperty`](-injected-property/index.md)`<`[`Factory`](-factory.md)`<A, T>?>.toProvider(crossinline arg: () -> A): <ERROR CLASS><`[`Provider`](-provider.md)`<T>?>`

Transforms an injected nullable factory property into an injected nullable provider property by currying the factory with the given argument.

### Parameters

`A` - The type of argument the factory takes.

`T` - The type of object to retrieve.

`arg` - A function that provides the argument that will be passed to the factory.

**Receiver**
The injected factory to curry.

**Return**
An injected provider property that, when called, will call the receiver factory (if not null) with the given argument.

