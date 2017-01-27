[com.github.salomonbrys.kodein](../index.md) / [InjectedNullableProviderProperty](.)

# InjectedNullableProviderProperty

`class InjectedNullableProviderProperty<out T : Any> : `[`InjectedProperty`](../-injected-property/index.md)`<`[`Provider`](../-provider.md)`<T>?>`

A read-only property delegate that injects a provider, or null if none is found.

### Parameters

`bind` - The bind (type &amp; tag) of the provider that will be injected.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `InjectedNullableProviderProperty(bind: `[`Bind`](../-kodein/-bind/index.md)`)`<br>A read-only property delegate that injects a provider, or null if none is found. |

### Properties

| Name | Summary |
|---|---|
| [_type](_type.md) | `val _type: String`<br>The type of the object to inject, *used for debug print only*. |

### Inherited Properties

| Name | Summary |
|---|---|
| [key](../-injected-property/key.md) | `val key: `[`Key`](../-kodein/-key/index.md)<br>The key of the value that will be injected. |
| [value](../-injected-property/value.md) | `val value: T`<br>The injected value. |

### Functions

| Name | Summary |
|---|---|
| [_getInjection](_get-injection.md) | `fun _getInjection(container: `[`KodeinContainer`](../-kodein-container/index.md)`): `[`Provider`](../-provider.md)`<T>?`<br>Gets the injected value from the container. |

### Inherited Functions

| Name | Summary |
|---|---|
| [getValue](../-injected-property/get-value.md) | `open operator fun getValue(thisRef: Any?, property: KProperty<*>): T`<br>Get the injected value. |
| [isInjected](../-injected-property/is-injected.md) | `fun isInjected(): Boolean` |
| [toString](../-injected-property/to-string.md) | `open fun toString(): String`<br>Stringify the injected value *if it has been injected*. |
