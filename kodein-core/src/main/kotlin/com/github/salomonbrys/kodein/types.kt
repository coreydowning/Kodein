package com.github.salomonbrys.kodein

typealias Factory<A, T> = (A) -> T

typealias Provider<T> = () -> T

typealias BindingsMap = Map<Kodein.Key, FactoryBinding<*, *>>
typealias BindingsListMap = Map<Kodein.Key, List<FactoryBinding<*, *>>>
