

KOtlin DEpendency INjection.

### All Types

| Name | Summary |
|---|---|
| [com.github.salomonbrys.kodein.AFactoryBinding](../com.github.salomonbrys.kodein/-a-factory-binding/index.md) | FactoryBinding base. |
| [com.github.salomonbrys.kodein.AProviderBinding](../com.github.salomonbrys.kodein/-a-provider-binding/index.md) | Provider base. |
| [com.github.salomonbrys.kodein.AScoped](../com.github.salomonbrys.kodein/-a-scoped/index.md) | A factory to bind a type and tag into a [Scope](../com.github.salomonbrys.kodein/-scope/index.md) or an [AutoScope](../com.github.salomonbrys.kodein/-auto-scope/index.md). |
| [android.content.AbstractThreadedSyncAdapter](../com.github.salomonbrys.kodein.android/android.content.-abstract-threaded-sync-adapter/index.md) (extensions in package com.github.salomonbrys.kodein.android) |  |
| [com.github.salomonbrys.kodein.android.ActivityInjector](../com.github.salomonbrys.kodein.android/-activity-injector/index.md) | An interface for adding injection and bindings to an Activity. |
| [com.github.salomonbrys.kodein.android.AndroidInjector](../com.github.salomonbrys.kodein.android/-android-injector/index.md) | An interface for adding a [KodeinInjector](../com.github.salomonbrys.kodein/-kodein-injector/index.md) to Android component classes (Activity, Fragment, Service, etc...) |
| [com.github.salomonbrys.kodein.android.AndroidScope](../com.github.salomonbrys.kodein.android/-android-scope/index.md) | Base interface from all Android scopes. |
| [com.github.salomonbrys.kodein.android.AppCompatActivityInjector](../com.github.salomonbrys.kodein.android/-app-compat-activity-injector/index.md) | An interface for adding injection and bindings to an AppCompatActivity. |
| [com.github.salomonbrys.kodein.AutoScope](../com.github.salomonbrys.kodein/-auto-scope/index.md) | An object that can, in addition to being a regular scope, can also get a context from a static environment. |
| [com.github.salomonbrys.kodein.BindingsListMap](../com.github.salomonbrys.kodein/-bindings-list-map.md) | A Map containing all bindings associated to their keys |
| [com.github.salomonbrys.kodein.BindingsMap](../com.github.salomonbrys.kodein/-bindings-map.md) | A Map containing all bindings associated to their keys |
| [com.github.salomonbrys.kodein.android.BroadcastReceiverInjector](../com.github.salomonbrys.kodein.android/-broadcast-receiver-injector/index.md) | An interface for adding injection and bindings to a BroadcastReceiver. |
| [com.github.salomonbrys.kodein.CAutoScopedSingleton](../com.github.salomonbrys.kodein/-c-auto-scoped-singleton/index.md) | Concrete auto-scoped singleton provider, effectively a `provider { -> T }`. |
| [com.github.salomonbrys.kodein.CScopedSingleton](../com.github.salomonbrys.kodein/-c-scoped-singleton/index.md) | Concrete scoped singleton factory, effectively a `factory { Scope -> T }`. |
| [com.github.salomonbrys.kodein.conf.ConfigurableKodein](../com.github.salomonbrys.kodein.conf/-configurable-kodein/index.md) | A class that can be used to configure a kodein object and as a kodein object. |
| [android.content.Context](../com.github.salomonbrys.kodein.android/android.content.-context/index.md) (extensions in package com.github.salomonbrys.kodein.android) |  |
| [com.github.salomonbrys.kodein.CurriedInjectorFactory](../com.github.salomonbrys.kodein/-curried-injector-factory/index.md) | Used to inject lazy providers or instances for factory bound types. |
| [com.github.salomonbrys.kodein.CurriedKodeinFactory](../com.github.salomonbrys.kodein/-curried-kodein-factory/index.md) | Allows to get a provider or an instance from a factory with a curried argument. |
| [com.github.salomonbrys.kodein.CurriedLazyKodeinFactory](../com.github.salomonbrys.kodein/-curried-lazy-kodein-factory/index.md) | Allows to get a lazy provider or instance from a lazy factory with a curried argument. |
| [android.app.Dialog](../com.github.salomonbrys.kodein.android/android.app.-dialog/index.md) (extensions in package com.github.salomonbrys.kodein.android) |  |
| [com.github.salomonbrys.kodein.Factory](../com.github.salomonbrys.kodein/-factory.md) | A Factory is a function that retrieves a T function of an A |
| [com.github.salomonbrys.kodein.FactoryBinding](../com.github.salomonbrys.kodein/-factory-binding/index.md) | Base class that knows how to get an instance. |
| [com.github.salomonbrys.kodein.FactoryKodein](../com.github.salomonbrys.kodein/-factory-kodein/index.md) | Kodein interface to be passed to factory scope methods. |
| [android.app.Fragment](../com.github.salomonbrys.kodein.android/android.app.-fragment/index.md) (extensions in package com.github.salomonbrys.kodein.android) |  |
| [android.support.v4.app.Fragment](../com.github.salomonbrys.kodein.android/android.support.v4.app.-fragment/index.md) (extensions in package com.github.salomonbrys.kodein.android) |  |
| [com.github.salomonbrys.kodein.android.FragmentActivityInjector](../com.github.salomonbrys.kodein.android/-fragment-activity-injector/index.md) | An interface for adding injection and bindings to a FragmentActivity. |
| [com.github.salomonbrys.kodein.android.FragmentInjector](../com.github.salomonbrys.kodein.android/-fragment-injector/index.md) | An interface for adding injection and bindings to a Fragment. |
| [kotlin.Function1](../com.github.salomonbrys.kodein/kotlin.-function1/index.md) (extensions in package com.github.salomonbrys.kodein) |  |
| [com.github.salomonbrys.kodein.InjectedFactoryProperty](../com.github.salomonbrys.kodein/-injected-factory-property/index.md) | A read-only property delegate that injects a factory. |
| [com.github.salomonbrys.kodein.InjectedInstanceProperty](../com.github.salomonbrys.kodein/-injected-instance-property/index.md) | A read-only property delegate that injects an instance. |
| [com.github.salomonbrys.kodein.InjectedNullableFactoryProperty](../com.github.salomonbrys.kodein/-injected-nullable-factory-property/index.md) | A read-only property delegate that injects a factory, or null if none is found. |
| [com.github.salomonbrys.kodein.InjectedNullableInstanceProperty](../com.github.salomonbrys.kodein/-injected-nullable-instance-property/index.md) | A read-only property delegate that injects an instance, or null if none is found. |
| [com.github.salomonbrys.kodein.InjectedNullableProviderProperty](../com.github.salomonbrys.kodein/-injected-nullable-provider-property/index.md) | A read-only property delegate that injects a provider, or null if none is found. |
| [com.github.salomonbrys.kodein.InjectedProperty](../com.github.salomonbrys.kodein/-injected-property/index.md) | Read only property delegate for an injected value. |
| [com.github.salomonbrys.kodein.InjectedProviderProperty](../com.github.salomonbrys.kodein/-injected-provider-property/index.md) | A read-only property delegate that injects a provider. |
| [com.github.salomonbrys.kodein.android.IntentServiceInjector](../com.github.salomonbrys.kodein.android/-intent-service-injector/index.md) | An interface for adding injection and bindings to an IntentService. |
| [com.github.salomonbrys.kodein.Kodein](../com.github.salomonbrys.kodein/-kodein/index.md) | KOtlin DEpendency INjection. |
| [com.github.salomonbrys.kodein.android.KodeinActivity](../com.github.salomonbrys.kodein.android/-kodein-activity/index.md) | A base class that manages an [ActivityInjector](../com.github.salomonbrys.kodein.android/-activity-injector/index.md) for easy bootstrapping of Kodein.
Injections will be available after `super.onCreate` and will be destroyed after `super.onDestroy`. |
| [com.github.salomonbrys.kodein.android.KodeinAppCompatActivity](../com.github.salomonbrys.kodein.android/-kodein-app-compat-activity/index.md) | A base class that manages an [AppCompatActivityInjector](../com.github.salomonbrys.kodein.android/-app-compat-activity-injector/index.md) for easy bootstrapping of Kodein.
Injections will be available after `super.onCreate` and will be destroyed after `super.onDestroy`. |
| [com.github.salomonbrys.kodein.KodeinAware](../com.github.salomonbrys.kodein/-kodein-aware.md) | Any class that extends this interface can use Kodein "seamlessly". |
| [com.github.salomonbrys.kodein.KodeinAwareBase](../com.github.salomonbrys.kodein/-kodein-aware-base/index.md) | Base [KodeinAware](../com.github.salomonbrys.kodein/-kodein-aware.md) interface. |
| [com.github.salomonbrys.kodein.android.KodeinBroadcastReceiver](../com.github.salomonbrys.kodein.android/-kodein-broadcast-receiver/index.md) | A base class that manages a [BroadcastReceiverInjector](../com.github.salomonbrys.kodein.android/-broadcast-receiver-injector/index.md) for easy bootstrapping of Kodein.
Injections will be available as soon as [onBroadcastReceived](../com.github.salomonbrys.kodein.android/-kodein-broadcast-receiver/on-broadcast-received.md) is called and will be destroyed immediately after it returns. |
| [com.github.salomonbrys.kodein.KodeinContainer](../com.github.salomonbrys.kodein/-kodein-container/index.md) | Container class where the bindings and their factories are stored. |
| [com.github.salomonbrys.kodein.android.KodeinFragment](../com.github.salomonbrys.kodein.android/-kodein-fragment/index.md) | A base class that manages a [FragmentInjector](../com.github.salomonbrys.kodein.android/-fragment-injector/index.md) for easy bootstrapping of Kodein.
Injections will be available after `super.onCreate` and will be destroyed after `super.onDestroy`. |
| [com.github.salomonbrys.kodein.android.KodeinFragmentActivity](../com.github.salomonbrys.kodein.android/-kodein-fragment-activity/index.md) | A base class that manages a [FragmentActivityInjector](../com.github.salomonbrys.kodein.android/-fragment-activity-injector/index.md) for easy bootstrapping of Kodein.
Injections will be available after `super.onCreate` and will be destroyed after `super.onDestroy`. |
| [com.github.salomonbrys.kodein.conf.KodeinGlobalAware](../com.github.salomonbrys.kodein.conf/-kodein-global-aware/index.md) | A `KodeinAware` class that needs no implementation because the kodein used will be the [global](../com.github.salomonbrys.kodein.conf/global.md) One True Kodein. |
| [com.github.salomonbrys.kodein.KodeinInjected](../com.github.salomonbrys.kodein/-kodein-injected.md) | Any class that extends this interface can be injected "seamlessly". |
| [com.github.salomonbrys.kodein.KodeinInjectedBase](../com.github.salomonbrys.kodein/-kodein-injected-base/index.md) | Base [KodeinInjected](../com.github.salomonbrys.kodein/-kodein-injected.md) interface. |
| [com.github.salomonbrys.kodein.KodeinInjector](../com.github.salomonbrys.kodein/-kodein-injector/index.md) | An injector is an object which creates injected property delegates **before** having access to a Kodein instance. |
| [com.github.salomonbrys.kodein.android.KodeinIntentService](../com.github.salomonbrys.kodein.android/-kodein-intent-service/index.md) | A base class that manages an [IntentServiceInjector](../com.github.salomonbrys.kodein.android/-intent-service-injector/index.md) for easy bootstrapping of Kodein.
Injections will be available after `super.onCreate` and will be destroyed after `super.onDestroy`. |
| [com.github.salomonbrys.kodein.android.KodeinService](../com.github.salomonbrys.kodein.android/-kodein-service/index.md) | A base class that manages a [ServiceInjector](../com.github.salomonbrys.kodein.android/-service-injector/index.md) for easy bootstrapping of Kodein.
Injections will be available after `super.onCreate` and will be destroyed after `super.onDestroy`. |
| [com.github.salomonbrys.kodein.android.KodeinSupportFragment](../com.github.salomonbrys.kodein.android/-kodein-support-fragment/index.md) | A base class that manages a [SupportFragmentInjector](../com.github.salomonbrys.kodein.android/-support-fragment-injector/index.md) for easy bootstrapping of Kodein.
Injections will be available after `super.onCreate` and will be destroyed after `super.onDestroy`. |
| [com.github.salomonbrys.kodein.KodeinWrappedType](../com.github.salomonbrys.kodein/-kodein-wrapped-type/index.md) | Wraps a ParameterizedType and implements hashCode / equals. |
| [com.github.salomonbrys.kodein.LazyKodein](../com.github.salomonbrys.kodein/-lazy-kodein/index.md) | An object that wraps a Kodein `Lazy` object and acts both as a `Lazy` property delegate &amp; a function. |
| [com.github.salomonbrys.kodein.LazyKodeinAware](../com.github.salomonbrys.kodein/-lazy-kodein-aware.md) | Any class that extends this interface can use Kodein to "seamlessly" get lazy properties. |
| [com.github.salomonbrys.kodein.LazyKodeinAwareBase](../com.github.salomonbrys.kodein/-lazy-kodein-aware-base/index.md) | Base [LazyKodeinAware](../com.github.salomonbrys.kodein/-lazy-kodein-aware.md) interface. |
| [android.content.Loader](../com.github.salomonbrys.kodein.android/android.content.-loader/index.md) (extensions in package com.github.salomonbrys.kodein.android) |  |
| [android.support.v4.content.Loader](../com.github.salomonbrys.kodein.android/android.support.v4.content.-loader/index.md) (extensions in package com.github.salomonbrys.kodein.android) |  |
| [kotlin.collections.Map](../com.github.salomonbrys.kodein/kotlin.collections.-map/index.md) (extensions in package com.github.salomonbrys.kodein) |  |
| [com.github.salomonbrys.kodein.Provider](../com.github.salomonbrys.kodein/-provider.md) | A Factory is a function that retrieves a T |
| [com.github.salomonbrys.kodein.ProviderBinding](../com.github.salomonbrys.kodein/-provider-binding/index.md) |  |
| [com.github.salomonbrys.kodein.ProviderKodein](../com.github.salomonbrys.kodein/-provider-kodein/index.md) | Kodein interface to be passed to provider or instance scope methods. |
| [com.github.salomonbrys.kodein.Scope](../com.github.salomonbrys.kodein/-scope/index.md) | An object capable of providing a [ScopeRegistry](../com.github.salomonbrys.kodein/-scope-registry/index.md) for a given `C` context. |
| [com.github.salomonbrys.kodein.ScopeRegistry](../com.github.salomonbrys.kodein/-scope-registry/index.md) | Represents a scope: used to store and retrieve scoped singleton objects. |
| [com.github.salomonbrys.kodein.SequenceProviderKodein](../com.github.salomonbrys.kodein/-sequence-provider-kodein/index.md) | Allows a coroutine to generate a sequence AND access transitive dependencies. |
| [com.github.salomonbrys.kodein.android.ServiceInjector](../com.github.salomonbrys.kodein.android/-service-injector/index.md) | An interface for adding injection and bindings to a Service. |
| [com.github.salomonbrys.kodein.android.SupportFragmentInjector](../com.github.salomonbrys.kodein.android/-support-fragment-injector/index.md) | An interface for adding injection and bindings to a android.support.v4.app.Fragment. |
| [com.github.salomonbrys.kodein.TKodein](../com.github.salomonbrys.kodein/-t-kodein/index.md) | Typed access to Kodein dependency injection. Can be used in Java. |
| [java.lang.reflect.Type](../com.github.salomonbrys.kodein/java.lang.reflect.-type/index.md) (extensions in package com.github.salomonbrys.kodein) |  |
| [com.github.salomonbrys.kodein.TypeReference](../com.github.salomonbrys.kodein/-type-reference/index.md) | Class used to get a generic type at runtime. |
| [com.github.salomonbrys.kodein.TypeToken](../com.github.salomonbrys.kodein/-type-token/index.md) | An interface that contains a simple [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) but is parameterized to enable type safety. |
| [android.view.View](../com.github.salomonbrys.kodein.android/android.view.-view/index.md) (extensions in package com.github.salomonbrys.kodein.android) |  |
| [com.github.salomonbrys.kodein.android.androidActivityScope](../com.github.salomonbrys.kodein.android/android-activity-scope/index.md) | Android's activity scope. Allows to register activity-specific singletons. |
| [com.github.salomonbrys.kodein.android.androidBroadcastReceiverScope](../com.github.salomonbrys.kodein.android/android-broadcast-receiver-scope/index.md) | Android's broadcast receiver scope. Allows to register broadcast receiver-specific singletons. |
| [com.github.salomonbrys.kodein.android.androidContextScope](../com.github.salomonbrys.kodein.android/android-context-scope/index.md) | Android's context scope. Allows to register context-specific singletons. |
| [com.github.salomonbrys.kodein.android.androidFragmentScope](../com.github.salomonbrys.kodein.android/android-fragment-scope/index.md) | Android's fragment scope. Allows to register fragment-specific singletons. |
| [com.github.salomonbrys.kodein.android.androidServiceScope](../com.github.salomonbrys.kodein.android/android-service-scope/index.md) | Android's service scope. Allows to register service-specific singletons. |
| [com.github.salomonbrys.kodein.android.androidSupportFragmentScope](../com.github.salomonbrys.kodein.android/android-support-fragment-scope/index.md) | Android's support fragment scope. Allows to register support fragment-specific singletons. |
