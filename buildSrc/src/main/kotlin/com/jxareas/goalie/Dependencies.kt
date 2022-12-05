object Dependencies {
    object Android {
        private const val KOTLIN_CORE_VERSION = "1.7.0"
        const val KOTLIN_CORE =
            "androidx.core:core-ktx:$KOTLIN_CORE_VERSION"

        private const val ANDROIDX_APPCOMPAT_VERSION = "1.6.0-rc01"
        const val ANDROIDX_APPCOMPAT =
            "androidx.appcompat:appcompat:$ANDROIDX_APPCOMPAT_VERSION"

        private const val MATERIAL_VERSION = "1.7.0"
        const val MATERIAL =
            "com.google.android.material:material:$MATERIAL_VERSION"

        private const val CONSTRAINT_LAYOUT_VERSION = "2.1.4"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:$CONSTRAINT_LAYOUT_VERSION"

        private const val JUNIT_VERSION = "4.13.2"
        const val JUNIT =
            "junit:junit:$JUNIT_VERSION"

        private const val JUNIT_EXT_VERSION = "1.1.4"
        const val JUNIT_EXT =
            "androidx.test.ext:junit:$JUNIT_EXT_VERSION"

        private const val ESPRESSO_CORE_VERSION = "3.5.0"
        const val ESPRESSO_CORE =
            "androidx.test.espresso:espresso-core:$ESPRESSO_CORE_VERSION"

        private const val SPLASH_SCREEN_VERSION = "1.0.0"
        const val SPLASH_SCREEN = "androidx.core:core-splashscreen:$SPLASH_SCREEN_VERSION"

        private const val KOTLINX_COROUTINES_VERSION = "1.6.0"
        const val KOTLINX_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$KOTLINX_COROUTINES_VERSION"
    }

    object Navigation {
        private const val NAVIGATION_VERSION = "2.4.1"
        const val SAFE_ARGS =
            "androidx.navigation:navigation-safe-args-gradle-plugin:$NAVIGATION_VERSION"
        const val NAVIGATION_FRAGMENT =
            "androidx.navigation:navigation-fragment:$NAVIGATION_VERSION"
        const val NAVIGATION_UI =
            "androidx.navigation:navigation-ui:$NAVIGATION_VERSION"
    }

    object Dagger {
        private const val DAGGER_HILT_VERSION = "2.43.2"
        const val HILT =
            "com.google.dagger:hilt-android:$DAGGER_HILT_VERSION"
        const val HILT_PLUGIN =
            "com.google.dagger:hilt-android-gradle-plugin:$DAGGER_HILT_VERSION"
        const val HILT_COMPILER =
            "com.google.dagger:hilt-compiler:$DAGGER_HILT_VERSION"
    }

    object Coil {
        private const val COIL_VERSION = "2.1.0"
        const val COIL = "io.coil-kt:coil:$COIL_VERSION"
    }

    object KotlinSerialization {
        private const val KOTLIN_SERIALIZATION_VERSION = "1.6.10"
        const val SERIALIZATION =
            "org.jetbrains.kotlin:kotlin-serialization:$KOTLIN_SERIALIZATION_VERSION"
    }

    object Network {
        private const val OKHTTP_VERSION = "4.10.0"
        const val OKHTTP_CLIENT = "com.squareup.okhttp3:okhttp:$OKHTTP_VERSION"
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:$OKHTTP_VERSION"

        private const val RETROFIT_VERSION = "2.9.0"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    }

}
