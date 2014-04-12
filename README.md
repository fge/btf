## Read me first

This project, as of version 1.1, is licensed under both LGPLv3 and ASL 2.0. See
file LICENSE for more details. Versions 1.0 and lower are licensed under LGPLv3
only.

**Note the "L" in "LGPL". LGPL AND GPL ARE QUITE DIFFERENT!**

## What this is

This package contains interfaces to help for two design patterns:

* the builder pattern;
* another pattern, which I came up with, called the "freeze/thaw pattern".

All in all, it consists of only three Java source files, one per interface. Full source code is
included in this README.

## Current version

The current version is **1.2**.

## Maven artifact

```xml
<dependency>
    <groupId>com.github.fge</groupId>
    <artifactId>btf</artifactId>
    <version>your-version-here</version>
</dependency>
```

## Source

### Builder

The full source of this interface is as follows:

```java
public interface Builder<T>
{
    T build();
}
```

There is really no need to comment on this interface; it is pretty obvious.

### Freeze/thaw

These are two interfaces:

```java
// Frozen
@Immutable
public interface Frozen<T extends Thawed<? extends Frozen<T>>>
{
    T thaw();
}

// Thawed
@NotThreadSafe
public interface Thawed<F extends Frozen<? extends Thawed<F>>>
{
    F freeze();
}
```

These interfaces are meant to be used in a pair of classes, where class `F` is immutable, and class
`T` is a modifiable version of `F`. The recommended use is as follows:

* `F` and `T` are in the same package; all instance variables of either class
  are package local;
* `F` has no publicly available constructor;
* `F` has a static factory method in order to return a "virgin" instance of `T`.

As you can see from the annotations (which are JSR 305 annotations), another part of the contract is
that any `F` instance is immutable; as to `T` instances, there is no guarantee as to their thread
safety.

In summary, the free/thaw pattern is a "reversible" builder pattern -- that is, a pattern where you
can create, from a "frozen", immutable instance, an equivalent builder instance bearing the same
characteristics.

