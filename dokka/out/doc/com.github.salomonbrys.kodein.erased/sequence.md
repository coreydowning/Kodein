[com.github.salomonbrys.kodein.erased](index.md) / [sequence](.)

# sequence

`inline fun <reified T : Any> `[`Builder`](../com.github.salomonbrys.kodein/-kodein/-builder/index.md)`.sequence(creator: <ERROR CLASS>, <no name provided>: (`[`SequenceProviderKodein`](../com.github.salomonbrys.kodein/-sequence-provider-kodein/index.md)`<T>) -> Unit): <ERROR CLASS>`

Creates a sequence provider: each time an instance is needed, the coroutine function [creator](sequence.md#com.github.salomonbrys.kodein.erased$sequence(com.github.salomonbrys.kodein.Kodein.Builder, , kotlin.Function1((com.github.salomonbrys.kodein.SequenceProviderKodein((com.github.salomonbrys.kodein.erased.sequence.T)), kotlin.Unit)))/creator) will be resumed.

The coroutine function can yeild values with [SequenceProviderKodein.yield](../com.github.salomonbrys.kodein/-sequence-provider-kodein/yield.md).

T generics will be erased!

### Parameters

`T` - The created type.

`creator` - The coroutine function that will be resumed each time an instance is requested.

**Return**
A provider ready to be bound.

