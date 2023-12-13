import org.gradle.jvm.tasks.Jar

val jmhLibraryVersion = "1.23"
val applicationStartClass = "com.imanushin.use.performance.StartKt"

plugins {
    java
    kotlin("jvm") version embeddedKotlinVersion
    id("me.champeau.gradle.jmh") version "0.5.3"
    id("com.github.ben-manes.versions") version "0.50.0"
}

kotlin {
    jvmToolchain(11)
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
}

tasks {
    create<Jar>("singleJar") {
        manifest {
            attributes("Main-Class" to applicationStartClass)
        }
    }
}

// there are several issues with JMH plugin on Windows (it doesn't have fork method, so jmh tries to simulates that):
// 1. gradle daemons should be stopped before, so execute .\gradlew.bat --stop before
// 2. jmh plugin is unable to compile code incrementally, so execute .\gradlew.bat clean before
// 3. jmh plugin has huge classpath, to change GRADLE_HOME folder to short path, like C:\g\
jmh {
    jmhVersion = jmhLibraryVersion
}