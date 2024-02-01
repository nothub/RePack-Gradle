### Local Deployment

deploy to `~/.m2/repository/`

```sh
./gradlew clean publishToMavenLocal
```

### Usage Example

###### build.gradle

```groovy
plugins {
    id 'java'
    id 'lol.hub.repack' version '0.1.0-SNAPSHOT'
}

group = 'foo.bar'
version = '42.0.0'
```

###### settings.gradle

```groovy
pluginManagement {
    repositories {
        mavenLocal()
        maven {
            url 'https://www.jitpack.io'
            content {
                includeGroup "com.github.ForestBlock-org"
            }
        }
    }
}

rootProject.name = 'My-Cool-Example'
```
