[com.github.salomonbrys.kodein](../index.md) / [TKodein](index.md) / [factory](.)

# factory

`fun factory(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`Factory`](../-factory.md)`<Any?, Any>`

Gets a factory for the given argument type, return type and tag.

### Parameters

`argType` - The type of argument the returned factory takes.

`type` - The type of object to retrieve with the returned factory.

`tag` - The bound tag, if any.

### Exceptions

`Kodein.NotFoundException` - If no factory was found.

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A factory.

`fun <T : Any> factory(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`Factory`](../-factory.md)`<Any?, T>`

Gets a factory of `T` for the given argument type, return type and tag.

### Parameters

`T` - The type of object to retrieve with the returned factory.

`argType` - The type of argument the returned factory takes.

`type` - The type of object to retrieve with the returned factory.

`tag` - The bound tag, if any.

### Exceptions

`Kodein.NotFoundException` - If no factory was found.

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A factory ot `T`.

`fun <T : Any> factory(argType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, type: `[`TypeToken`](../-type-token/index.md)`<T>, tag: Any? = null): `[`Factory`](../-factory.md)`<Any?, T>`

Gets a factory of `T` for the given argument type, return type and tag.

### Parameters

`T` - The type of object to retrieve with the returned factory.

`argType` - The type of argument the returned factory takes.

`type` - The type of object to retrieve with the returned factory.

`tag` - The bound tag, if any.

### Exceptions

`Kodein.NotFoundException` - If no factory was found.

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A factory of `T`.

`fun <A> factory(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`Factory`](../-factory.md)`<A, Any>`
`fun <A> factory(argType: `[`TypeToken`](../-type-token/index.md)`<A>, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, tag: Any? = null): `[`Factory`](../-factory.md)`<A, Any>`

Gets a factory for the given argument type, return type and tag.

### Parameters

`A` - The type of argument the returned factory takes.

`argType` - The type of argument the returned factory takes.

`type` - The type of object to retrieve with the returned factory.

`tag` - The bound tag, if any.

### Exceptions

`Kodein.NotFoundException` - If no factory was found.

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A factory.

`fun <A, T : Any> factory(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`Factory`](../-factory.md)`<A, T>`
`fun <A, T : Any> factory(argType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<A>, type: `[`TypeToken`](../-type-token/index.md)`<T>, tag: Any? = null): `[`Factory`](../-factory.md)`<A, T>`
`fun <A, T : Any> factory(argType: `[`TypeToken`](../-type-token/index.md)`<A>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, tag: Any? = null): `[`Factory`](../-factory.md)`<A, T>`
`fun <A, T : Any> factory(argType: `[`TypeToken`](../-type-token/index.md)`<A>, type: `[`TypeToken`](../-type-token/index.md)`<T>, tag: Any? = null): `[`Factory`](../-factory.md)`<A, T>`

Gets a factory of `T` for the given argument type, return type and tag.

### Parameters

`A` - The type of argument the returned factory takes.

`T` - The type of object to retrieve with the returned factory.

`argType` - The type of argument the returned factory takes.

`type` - The type of object to retrieve with the returned factory.

`tag` - The bound tag, if any.

### Exceptions

`Kodein.NotFoundException` - If no factory was found.

`Kodein.DependencyLoopException` - When calling the factory, if the value construction triggered a dependency loop.

**Return**
A factory of `T`.

