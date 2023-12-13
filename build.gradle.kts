import org.gradle.jvm.tasks.Jar

plugins {
    java
    kotlin("jvm") version embeddedKotlinVersion
    alias(libs.plugins.me.champeau.jmh)
    alias(libs.plugins.com.github.ben.manes.versions)
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib"))
}

// there are several issues with JMH plugin on Windows (it doesn't have fork method, so jmh tries to simulates that):
// 1. gradle daemons should be stopped before, so execute .\gradlew.bat --stop before
// 2. jmh plugin is unable to compile code incrementally, so execute .\gradlew.bat clean before
// 3. jmh plugin has huge classpath, to change GRADLE_HOME folder to short path, like C:\g\
jmh {
    jmhVersion = libs.versions.jmh.get()
}