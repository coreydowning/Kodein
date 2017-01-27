/!\ WARNING /!\
---------------

This is the version 4 branch. At the moment, this branch **only exists as an experimentation** to understand how can
kodein take advantage of Kotlin 1.1, and if using can enhance Kodein's experience.

This branch is *not* published in any Maven repository at the moment.

---

<img alt="KODEIN" src="https://raw.githubusercontent.com/SalomonBrys/Kodein/master/Kodein-logo.png" width="700">

[![Kotlin 1.0](https://img.shields.io/badge/Kotlin-1.0.3-blue.svg)](http://kotlinlang.org)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.salomonbrys.kodein/kodein.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.salomonbrys.kodein%22)
[![Travis](https://img.shields.io/travis/SalomonBrys/Kodein.svg)](https://travis-ci.org/SalomonBrys/Kodein/builds)
[![MIT License](https://img.shields.io/github/license/salomonbrys/kodein.svg)](https://github.com/SalomonBrys/Kodein/blob/master/LICENSE.txt)
[![GitHub issues](https://img.shields.io/github/issues/SalomonBrys/Kodein.svg)](https://github.com/SalomonBrys/Kodein/issues)
[![Slack channel](https://img.shields.io/badge/Chat-Slack-green.svg)](https://kotlinlang.slack.com/messages/kodein/)
[![Donate](https://img.shields.io/badge/Backing-Donate-orange.svg)](https://salomonbrys.github.io/Kodein/#_donate)


KOtlin DEpendency INjection
===========================

Kodein is a very simple and yet very useful dependency retrieval container. it is very easy to use and configure.

Kodein allows you to:

- Lazily instantiate your dependencies when needed
- Stop caring about dependency initialization order
- Easily bind classes or interfaces to their instance or provider
- Easily debug your dependency bindings and recursions

Kodein does *not* allow you to:

- Automatically instantiate your dependencies via injected constructor and reflexivity. For that, you need Guice.
- Have dependency injection validated at compile time. For that, you need Dagger.

Kodein is a good choice because:

- It is small, fast and optimized (makes extensive use of `inline`)
- It proposes a very simple and readable declarative DSL
- It is not subject to type erasure (like Java)
- It integrates nicely with Android
- It proposes a very kotlin-esque idiomatic API
- It can be used in plain Java


Example
-------

An example is always better than a thousand words:

```kotlin
val kodein = Kodein {
    bind<Dice>() with provider { RandomDice(0, 5) }
    bind<DataSource>() with singleton { SqliteDS.open("path/to/file") }
}

class Controller(private val kodein: Kodein) {
    private val ds: DataSource = kodein.instance()
}
```


Read more
---------

Kodein version 3 is the current major version available:

- **[Kodein 3 full documentation](https://salomonbrys.github.io/Kodein/)**
- [Kodein 3 API reference](https://github.com/SalomonBrys/Kodein/blob/master/dokka/out/doc/index.md)

If you are still using Kodein 2, here is the relevant documentation:

- [Kodein 2 documentation](https://github.com/SalomonBrys/Kodein/blob/master/README2.md)
- [Kodein 2 to 3 migration guide](https://github.com/SalomonBrys/Kodein/blob/master/MIGRATION-2-3.md)