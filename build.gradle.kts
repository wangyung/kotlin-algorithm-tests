
buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.11")
    }
}

group = "idv.freddie"
version = "1.0-SNAPSHOT"

plugins {
    application
    kotlin("jvm") version "1.3.11"
}

dependencies {
    implementation(kotlin("stdlib"))
}

repositories {
    jcenter()
}

application {
    mainClassName = "idv.freddie.tests.MainKt"
}
