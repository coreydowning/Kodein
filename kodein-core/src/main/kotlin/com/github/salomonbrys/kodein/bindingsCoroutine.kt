@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package com.github.salomonbrys.kodein

import java.lang.reflect.Type
import kotlin.coroutines.*

/**
 * Allows a coroutine to generate a sequence AND access transitive dependencies.
 *
 * @param T The type of instance of the bind.
 */
interface SequenceProviderKodein<T> : ProviderKodein {
    /**
     * Yields this value as the next instance.
     *
     * @param value The next instance for this bind.
     */
    suspend fun yield(value: T)

    /**
     * Yields these values as the next instances.
     *
     * @param iterator The next instances for this bind.
     */
    suspend fun yieldAll(iterator: Iterator<T>)

    /**
     * Yields these values as the next instances.
     *
     * @param elements The next instances for this bind.
     */
    suspend fun yieldAll(elements: Iterable<T>)

    /**
     * Yields these values as the next instances.
     *
     * @param sequence The next instances for this bind.
     */
    suspend fun yieldAll(sequence: Sequence<T>)
}

@PublishedApi
internal class CSequenceBinding<T: Any> private constructor (createdType: Type) : AProviderBinding<T>("sequence", createdType), SequenceProviderKodein<T>, Continuation<Unit> {

    private var _cont: Continuation<Unit>? = null

    private var _value: T? = null

    private var _iterator: Iterator<T>? = null

    private var _kodeinDelegate: ProviderKodein? = null

    override fun getInstance(kodein: ProviderKodein, key: Kodein.Key): T {
        _kodeinDelegate = kodein
        try {
            _iterator?.let { next ->
                if (!next.hasNext())
                    _iterator = null
                else
                    next.next().let {
                        _value = it
                        return it
                    }
            }
            _cont?.resume(Unit)
            return _value ?: throw IllegalStateException()
        }
        finally {
            _kodeinDelegate = null
        }
    }

    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resume(value: Unit) {
        _cont = null
    }

    override fun resumeWithException(exception: Throwable) {
        throw exception
    }

    override suspend fun yield(value: T) {
        _value = value
        return suspendCoroutine { _cont = it }
    }

    override suspend fun yieldAll(iterator: Iterator<T>) {
        if (!iterator.hasNext())
            return
        _value = iterator.next()
        _iterator = iterator
        return suspendCoroutine { _cont = it }
    }

    override suspend fun yieldAll(elements: Iterable<T>) {
        if (elements is Collection && elements.isEmpty()) return
        return yieldAll(elements.iterator())
    }

    override suspend fun yieldAll(sequence: Sequence<T>) = yieldAll(sequence.iterator())

    private val _kodein get() = _kodeinDelegate ?: throw IllegalStateException()
    override val typed get() = _kodein.typed
    override val container get() = _kodein.container
    override fun <T : Any> overriddenProvider() = _kodein.overriddenProvider<T>()
    override fun <T : Any> overriddenProviderOrNull() = _kodein.overriddenProviderOrNull<T>()
    override fun <T : Any> overriddenInstance() = _kodein.overriddenInstance<T>()
    override fun <T : Any> overriddenInstanceOrNull() = _kodein.overriddenInstanceOrNull<T>()

    companion object {
        operator fun <T: Any> invoke(createdType: Type, creator: suspend SequenceProviderKodein<T>.() -> Unit): CSequenceBinding<T> {
            val binding = CSequenceBinding<T>(createdType)
            binding._cont = creator.createCoroutine(receiver = binding, completion = binding)
            return binding
        }
    }
}

/**
 * Creates a sequence provider: each time an instance is needed, the coroutine function [creator] will be resumed.
 *
 * The coroutine function can yeild values with [SequenceProviderKodein.yield].
 *
 * T generics will be kept.
 *
 * @param T The created type.
 * @param creator The coroutine function that will be resumed each time an instance is requested.
 * @return A provider ready to be bound.
 */
@Suppress("unused")
inline fun <reified T : Any> Kodein.Builder.genericSequence(creator: suspend SequenceProviderKodein<T>.() -> Unit): ProviderBinding<T> = CSequenceBinding(genericToken<T>().type, creator)

/**
 * Creates a sequence provider: each time an instance is needed, the coroutine function [creator] will be resumed.
 *
 * The coroutine function can yeild values with [SequenceProviderKodein.yield].
 *
 * T generics will be erased!
 *
 * @param T The created type.
 * @param creator The coroutine function that will be resumed each time an instance is requested.
 * @return A provider ready to be bound.
 */
@Suppress("unused")
inline fun <reified T : Any> Kodein.Builder.erasedSequence(creator: suspend SequenceProviderKodein<T>.() -> Unit): ProviderBinding<T> = CSequenceBinding(T::class.java, creator)
