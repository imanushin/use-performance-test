import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinJvmTarget = "13"
val jmhLibraryVersion = "1.23"
val applicationStartClass = "com.imanushin.use.performance.StartKt"

plugins {
    application
    kotlin("jvm") version "1.3.71"
    id("me.champeau.gradle.jmh") version "0.5.0"
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = kotlinJvmTarget
    }

    create<Jar>("singleJar") {
        manifest {
            attributes("Main-Class" to applicationStartClass)
        }
    }
}

application {
    mainClassName = applicationStartClass
}

// there are several issues with JMH plugin on Windows (it doesn't have fork method, so jmh tries to simulates that):
// 1. gradle daemons should be stopped before, so execute .\gradlew.bat --stop before
// 2. jmh plugin is unable to compile code incrementally, so execute .\gradlew.bat clean before
// 3. jmh plugin has huge classpath, to change GRADLE_HOME folder to short path, like C:\g\
jmh {
    jmhVersion = jmhLibraryVersion
}