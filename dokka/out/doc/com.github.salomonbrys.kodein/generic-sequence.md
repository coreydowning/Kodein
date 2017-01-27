[com.github.salomonbrys.kodein](index.md) / [genericSequence](.)

# genericSequence

`inline fun <reified T : Any> `[`Builder`](-kodein/-builder/index.md)`.genericSequence(creator: <ERROR CLASS>, <no name provided>: (`[`SequenceProviderKodein`](-sequence-provider-kodein/index.md)`<T>) -> Unit): `[`ProviderBinding`](-provider-binding/index.md)`<T>`

Creates a sequence provider: each time an instance is needed, the coroutine function [creator](generic-sequence.md#com.github.salomonbrys.kodein$genericSequence(com.github.salomonbrys.kodein.Kodein.Builder, , kotlin.Function1((com.github.salomonbrys.kodein.SequenceProviderKodein((com.github.salomonbrys.kodein.genericSequence.T)), kotlin.Unit)))/creator) will be resumed.

The coroutine function can yeild values with [SequenceProviderKodein.yield](-sequence-provider-kodein/yield.md).

T generics will be kept.

### Parameters

`T` - The created type.

`creator` - The coroutine function that will be resumed each time an instance is requested.

**Return**
A provider ready to be bound.

