package com.github.salomonbrys.kodein

/**
 * A Factory is a function that retrieves a T function of an A
 *
 * @param A The type of the argument
 * @param T The type of the instance to retrieve
 */
typealias Factory<A, T> = (A) -> T

/**
 * A Factory is a function that retrieves a T
 *
 * @param T The type of the instance to retrieve
 */
typealias Provider<T> = () -> T

/**
 * A Map containing all bindings associated to their keys
 */
typealias BindingsMap = Map<Kodein.Key, FactoryBinding<*, *>>

/**
 * A Map containing all bindings associated to their keys
 */
typealias BindingsListMap = Map<Kodein.Key, List<FactoryBinding<*, *>>>
