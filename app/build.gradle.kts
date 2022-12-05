import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id(BuildPlugins.ANDROID_APPLICATION_PLUGIN)
    id(BuildPlugins.JETBRAINS_KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KTLINT)
    id(BuildPlugins.SAFE_ARGS)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.DAGGER_HILT)
    id(BuildPlugins.KOTLIN_SERIALIZATION)
}

android {
    namespace = "com.jxareas.goalie"
    compileSdk = ProjectProperties.COMPILE_SDK

    defaultConfig {
        applicationId = ProjectProperties.APPLICATION_ID
        minSdk = ProjectProperties.MIN_SDK
        targetSdk = ProjectProperties.TARGET_SDK
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    android.sourceSets.all {
        kotlin.srcDir("src/$name/kotlin")
    }

    packagingOptions {
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("LICENSE.txt")
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

kapt {
    generateStubs = true
    correctErrorTypes = true
}

tasks.getByPath("preBuild").dependsOn("ktlintFormat")

ktlint {
    android.set(true)
    ignoreFailures.set(false)
    disabledRules.add("no-wildcard-imports")
    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
    }
}

dependencies {
    // Android
    implementation(Dependencies.Android.ANDROIDX_APPCOMPAT)
    implementation(Dependencies.Android.MATERIAL)
    implementation(Dependencies.Android.CONSTRAINT_LAYOUT)

    // Testing
    testImplementation(Dependencies.Android.JUNIT)
    androidTestImplementation(Dependencies.Android.JUNIT_EXT)
    androidTestImplementation(Dependencies.Android.ESPRESSO_CORE)

    // Kotlin Coroutines
    implementation(Dependencies.Android.KOTLIN_CORE)
    implementation(Dependencies.Android.KOTLINX_COROUTINES)

    // Jetpack Navigation
    implementation(Dependencies.Navigation.NAVIGATION_FRAGMENT)
    implementation(Dependencies.Navigation.NAVIGATION_UI)

    // OkHttp
    implementation(Dependencies.Network.OKHTTP_CLIENT)
    implementation(Dependencies.Network.LOGGING_INTERCEPTOR)

    // Retrofit
    implementation(Dependencies.Network.RETROFIT)

    // Dagger Hilt
    implementation(Dependencies.Dagger.HILT)
    kapt(Dependencies.Dagger.HILT_COMPILER)

    // Coil
    implementation(Dependencies.Coil.COIL)

    // Splash Screen
    implementation(Dependencies.Android.SPLASH_SCREEN)
}
