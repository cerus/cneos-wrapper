# cneos-wrapper

Nasa SSD & CNEOS API wrapper written in Java

## Implemented API wrappers

API | Description
------ | ------
CAD | Asteroid and comet close approaches to the planets in the past and future
Fireball | Fireball atmospheric impact data reported by US Government sensors

## Usage

Installation using Maven:

```xml

<project>
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependency>
        <groupId>com.github.cerus</groupId>
        <artifactId>cneos-wrapper</artifactId>
        <version>Tag</version>
    </dependency>
</project>
```

You can obtain a wrapper instance for the desired API using the `CNEOSApi` class (e.g. `CNEOSApi#getNewCADApiClient()`).

Most API wrappers provide useful query builders. Take a look at the [JavaDoc](https://cerus.github.io/cneos-wrapper/) for more information.