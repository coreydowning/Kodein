[com.github.salomonbrys.kodein](../../index.md) / [KodeinInjector](../index.md) / [TInjector](index.md) / [factoryOrNull](.)

# factoryOrNull

`fun factoryOrNull(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<Any?, Any>?>`

Creates a property delegate that will hold a factory, or null if none is found.

### Parameters

`argType` - The type of argument the factory held by this property takes.

`type` - The type of object to retrieve with the factory held by this property.

`tag` - The bound tag, if any.

### Exceptions

`KodeinInjector.UninjectedException` - When accessing the property, if it was accessed before calling [KodeinInjectedBase.inject](../../-kodein-injected-base/inject.md).

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A property delegate that will lazily provide a factory, or null if no factory was found.

`fun <T : Any> factoryOrNull(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<Any?, T>?>`
`fun <T : Any> factoryOrNull(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`TypeToken`](../../-type-token/index.md)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<Any?, T>?>`

Creates a property delegate that will hold a factory, or null if none is found.

### Parameters

`T` - The type of object to retrieve with the factory held by this property.

`argType` - The type of argument the factory held by this property takes.

`type` - The type of object to retrieve with the factory held by this property.

`tag` - The bound tag, if any.

### Exceptions

`KodeinInjector.UninjectedException` - When accessing the property, if it was accessed before calling [KodeinInjectedBase.inject](../../-kodein-injected-base/inject.md).

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A property delegate that will lazily provide a factory of `T`, or null if no factory was found.

`fun <A> factoryOrNull(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, Any>?>`
`fun <A> factoryOrNull(argType: `[`TypeToken`](../../-type-token/index.md)`<A>, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, Any>?>`

Creates a property delegate that will hold a factory, or null if none is found.

### Parameters

`A` - The type of argument the factory held by this property takes.

`argType` - The type of argument the factory held by this property takes.

`type` - The type of object to retrieve with the factory held by this property.

`tag` - The bound tag, if any.

### Exceptions

`KodeinInjector.UninjectedException` - When accessing the property, if it was accessed before calling [KodeinInjectedBase.inject](../../-kodein-injected-base/inject.md).

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A property delegate that will lazily provide a factory, or null if no factory was found.

`fun <A, T : Any> factoryOrNull(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, T>?>`
`fun <A, T : Any> factoryOrNull(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`TypeToken`](../../-type-token/index.md)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, T>?>`
`fun <A, T : Any> factoryOrNull(argType: `[`TypeToken`](../../-type-token/index.md)`<A>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, T>?>`
`fun <A, T : Any> factoryOrNull(argType: `[`TypeToken`](../../-type-token/index.md)`<A>, type: `[`TypeToken`](../../-type-token/index.md)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, T>?>`

Creates a property delegate that will hold a factory, or null if none is found.

### Parameters

`A` - The type of argument the factory held by this property takes.

`T` - The type of object to retrieve with the factory held by this property.

`argType` - The type of argument the factory held by this property takes.

`type` - The type of object to retrieve with the factory held by this property.

`tag` - The bound tag, if any.

### Exceptions

`KodeinInjector.UninjectedException` - When accessing the property, if it was accessed before calling [KodeinInjectedBase.inject](../../-kodein-injected-base/inject.md).

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A property delegate that will lazily provide a factory of `T`, or null if no factory was found.

