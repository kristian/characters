Characters
==========

This project provides a very simple `Characters` class, to perform character based operations on strings. List of methods:

 - `equals`: Checks whether a given `String` _matches_ the character.
 - `contains`: Checks whether a given `String` _contains_ the character.
 - `startsWith`: Checks whether a given `String` _starts_ with the character.
 - `endsWith`: Checks whether a given `String` _ends_ with the character.
 - `indexOf`: Returns the index within a given `String` of the _first occurrence_ of the character.
 - `lastIndexOf`: Returns the index within a given `String` of the _last occurrence_ of the character.
 - `replace`: _Replaces_ all occurrences of the character in a given `String` by a given replacement.
 - `trim`: Returns a copy of the given `String` with _leading and trailing_ occurrences of the character omitted.
 - `leftTrim`: Returns a copy of the given `String` with _leading_ occurrences of the character omitted.
 - `rightTrim`: Returns a copy of the given `String` with _trailing_ occurrences of the character omitted.
 - `condense`: _Condenses_ multiple occurrences of the character in a given `String` into one occurrence.
 - `split`: _Splits_ a given `String` around matches of the character.

There a two predefined characters-classes for matching `WHITESPACE` and `NEW_LINE`. For any single character the `valueOf` method can be used to receive a `Characters` object. For any custom character-class two public constructors are provided: `Characters(char character,Pattern pattern)` and `Characters(char character,Pattern match,Pattern split)`.

Usage
-----

Feel free to use the class `lc.kra.Characters` by copying the `Characters.java` file to your project.

### Maven Dependency
Even easier, you can include characters from this GitHub repository by adding this dependency to your `pom.xml`:

```xml
<dependency>
  <groupId>lc.kra.characters</groupId>
  <artifactId>characters</artifactId>
  <version>0.1.0</version>
</dependency>
```

Additionally you will have to add the following repository to your `pom.xml`:

```xml
<repositories>
  <repository>
    <id>characters-mvn-repo</id>
    <url>https://raw.github.com/kristian/characters/mvn-repo/</url>
    <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </snapshots>
  </repository>
</repositories>
```

Build
-----

To build characters on your machine, checkout the repository, `cd` into it, and call:
```
mvn clean install
```

License
-------

The code is available under the terms of the [MIT License](http://opensource.org/licenses/MIT).