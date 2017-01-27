[com.github.salomonbrys.kodein.conf](../index.md) / [ConfigurableKodein](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`ConfigurableKodein(mutable: Boolean = false, allowSilentOverride: Boolean = false)`

A class that can be used to configure a kodein object and as a kodein object.

If you want it to be mutable, the [mutable](-init-.md#com.github.salomonbrys.kodein.conf.ConfigurableKodein$<init>(kotlin.Boolean, kotlin.Boolean)/mutable) property needs to be set **before** any dependency retrieval.
The non-mutable configuration methods ([addImport](add-import.md), [addExtend](add-extend.md) &amp; [addConfig](add-config.md)) needs to happen **before** any dependency retrieval.

### Parameters

`mutable` - Whether this Kodein can be mutated.

`allowSilentOverride` - Whether added configurations block are allowed non-explicit overrides.