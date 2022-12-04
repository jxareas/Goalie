// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = uri("https://jitpack.io"))
    }
    dependencies {
        classpath("com.android.application:com.android.application.gradle.plugin:7.3.1")
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}
