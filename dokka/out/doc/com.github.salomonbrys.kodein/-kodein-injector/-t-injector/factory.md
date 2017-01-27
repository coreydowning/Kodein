[com.github.salomonbrys.kodein](../../index.md) / [KodeinInjector](../index.md) / [TInjector](index.md) / [factory](.)

# factory

`fun factory(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<Any?, Any>>`

Creates an injected factory property delegate.

### Parameters

`argType` - The type of argument the factory held by this property takes.

`type` - The type of object to retrieve with the factory held by this property.

`tag` - The bound tag, if any.

### Exceptions

`KodeinInjector.UninjectedException` - When accessing the property, if it was accessed before calling [KodeinInjectedBase.inject](../../-kodein-injected-base/inject.md).

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A property delegate that will lazily provide a factory.

`fun <T : Any> factory(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<Any?, T>>`
`fun <T : Any> factory(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`TypeToken`](../../-type-token/index.md)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<Any?, T>>`

Creates an injected factory property delegate.

### Parameters

`T` - The type of object to retrieve with the factory held by this property.

`argType` - The type of argument the factory held by this property takes.

`type` - The type of object to retrieve with the factory held by this property.

`tag` - The bound tag, if any.

### Exceptions

`KodeinInjector.UninjectedException` - When accessing the property, if it was accessed before calling [KodeinInjectedBase.inject](../../-kodein-injected-base/inject.md).

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A property delegate that will lazily provide a factory of `T`.

`fun <A> factory(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, Any>>`
`fun <A> factory(argType: `[`TypeToken`](../../-type-token/index.md)`<A>, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, Any>>`

Creates an injected factory property delegate.

### Parameters

`A` - The type of argument the factory held by this property takes.

`argType` - The type of argument the factory held by this property takes.

`type` - The type of object to retrieve with the factory held by this property.

`tag` - The bound tag, if any.

### Exceptions

`KodeinInjector.UninjectedException` - When accessing the property, if it was accessed before calling [KodeinInjectedBase.inject](../../-kodein-injected-base/inject.md).

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A property delegate that will lazily provide a factory.

`fun <A, T : Any> factory(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, T>>`
`fun <A, T : Any> factory(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`TypeToken`](../../-type-token/index.md)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, T>>`
`fun <A, T : Any> factory(argType: `[`TypeToken`](../../-type-token/index.md)`<A>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, T>>`
`fun <A, T : Any> factory(argType: `[`TypeToken`](../../-type-token/index.md)`<A>, type: `[`TypeToken`](../../-type-token/index.md)`<T>, tag: Any? = null): `[`InjectedProperty`](../../-injected-property/index.md)`<`[`Factory`](../../-factory.md)`<A, T>>`

Creates an injected factory property delegate.

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
A property delegate that will lazily provide a factory of `T`.

