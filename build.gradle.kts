// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = uri("https://jitpack.io"))
    }
    dependencies {
        classpath("com.android.application:com.android.application.gradle.plugin:7.3.1")
        classpath(BuildPlugins.TOOLS_BUILD_GRADLE)
        classpath(BuildPlugins.KOTLIN_GRADLE_PLUGIN)
        classpath(Dependencies.Navigation.SAFE_ARGS)
        classpath(Dependencies.Dagger.HILT_PLUGIN)
        classpath(Dependencies.KotlinSerialization.SERIALIZATION)
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "10.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
