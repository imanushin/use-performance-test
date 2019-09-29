import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinJvmTarget = "12"
val jmhLibraryVersion = "1.21"
val applicationStartClass = "com.imanushin.use.performance.StartKt"

plugins {
    application
    kotlin("jvm") version "1.3.50"
    id("me.champeau.gradle.jmh") version "0.4.8"
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "12"
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

// there are several issues with JMH plugin:
// 1. gradle daemons should be stopped before, so execute .\gradlew.bat --stop before
// 2. jmh plugin is unable to compile code incrementally, so execute .\gradlew.bat clean before
// 3. jmh plugin has huge classpath, to change GRADLE_HOME folder to short path, like C:\g\
jmh {
    jmhVersion = jmhLibraryVersion
}