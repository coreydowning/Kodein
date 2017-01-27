[com.github.salomonbrys.kodein](../index.md) / [kotlin.Function1](index.md) / [toProvider](.)

# toProvider

`inline fun <A, T : Any> `[`Factory`](../-factory.md)`<A, T>.toProvider(crossinline arg: () -> A): `[`Provider`](../-provider.md)`<T>`

Transforms a factory function into a provider function by currying the factory with the given argument.

### Parameters

`A` - The type of argument the factory takes.

`T` - The type of object to retrieve.

`arg` - A function that provides the argument that will be passed to the factory.

**Receiver**
The factory to curry.

**Return**
A provider function that, when called, will call the receiver factory with the given argument.

