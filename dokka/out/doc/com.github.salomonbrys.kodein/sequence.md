[com.github.salomonbrys.kodein](index.md) / [sequence](.)

# sequence

`inline fun <reified T : Any> `[`Builder`](-kodein/-builder/index.md)`.sequence(creator: <ERROR CLASS>, <no name provided>: (`[`SequenceProviderKodein`](-sequence-provider-kodein/index.md)`<T>) -> Unit): <ERROR CLASS>`

Creates a sequence provider: each time an instance is needed, the coroutine function [creator](sequence.md#com.github.salomonbrys.kodein$sequence(com.github.salomonbrys.kodein.Kodein.Builder, , kotlin.Function1((com.github.salomonbrys.kodein.SequenceProviderKodein((com.github.salomonbrys.kodein.sequence.T)), kotlin.Unit)))/creator) will be resumed.

The coroutine function can yeild values with [SequenceProviderKodein.yield](-sequence-provider-kodein/yield.md).

T generics will be kept.

### Parameters

`T` - The created type.

`creator` - The coroutine function that will be resumed each time an instance is requested.

**Return**
A provider ready to be bound.

