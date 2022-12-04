
object Dependencies {
    object Android {
        private const val KOTLIN_CORE_VERSION = "1.7.0"
        const val KOTLIN_CORE =
            "androidx.core:core-ktx:$KOTLIN_CORE_VERSION"

        private const val ANDROIDX_APPCOMPAT_VERSION = "1.5.1"
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
    }
}
