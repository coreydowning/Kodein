[com.github.salomonbrys.kodein](../index.md) / [ASingleton](index.md) / [getInstance](.)

# getInstance

`open fun getInstance(kodein: `[`ProviderKodein`](../-provider-kodein/index.md)`, key: `[`Key`](../-kodein/-key/index.md)`): T`

Overrides [AProvider.getInstance](../-a-provider/get-instance.md)

Get an instance of type `T`.

Whether its a new instance or not entirely depends on implementation.

### Parameters

`kodein` - : A Kodein instance to use for transitive dependencies.

`key` - : The key of the instance to get.

**Return**
an instance of `T`.

