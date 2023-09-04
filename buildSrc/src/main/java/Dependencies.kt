object App {

    object Base {
        const val core = "androidx.core:core-ktx:1.10.1"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val lifecycleSaveState =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
        const val appCompat = "androidx.appcompat:appcompat:1.7.0-alpha03"
        const val activityCompose = "androidx.activity:activity-compose:1.8.0-alpha07"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val junit = "androidx.test.ext:junit-ktx:1.1.5"
        const val immutableCollections =
            "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.immutableCollections}"

        fun all() = listOf(
            core,
            junit,
            lifecycle,
            lifecycleSaveState,
            activityCompose,
            stdLib,
            immutableCollections
        )
    }

    object Compose {
        const val animations = "androidx.compose.animation:animation:${Versions.compose}"
        const val foundations = "androidx.compose.foundation:foundation:${Versions.compose}"

        @Deprecated("Use material3 instead")
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val material3 = "androidx.compose.material3:material3:${Versions.material3}"
        const val material3SizeClass =
            "androidx.compose.material3:material3-window-size-class:${Versions.material3}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val uiUtil = "androidx.compose.ui:ui-util:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:2.7.1"

        fun base() = listOf(
            animations,
            foundations,
            material3,
            material3SizeClass,
            runtime,
            ui,
            uiUtil,
            uiToolingPreview,
            navigation
        )

        fun debug() = listOf(uiTooling)
    }

    object Firebase {
        const val analytics = "com.google.firebase:firebase-analytics-ktx:21.3.0"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx:18.3.7"
        const val cloudMessaging = "com.google.firebase:firebase-messaging-ktx:23.1.2"

        fun all() = listOf(analytics, crashlytics, cloudMessaging)
    }

    object Accompanist {
        const val permissions =
            "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
        const val drawable =
            "com.google.accompanist:accompanist-drawablepainter:${Versions.accompanist}"

        fun all() = listOf(permissions, drawable)
    }

    object Images {
        const val coilLib = "io.coil-kt:coil-compose:${Versions.coil}"

        fun all() = listOf(coilLib)
    }

    object Animation {
        const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"

        fun all() = listOf(lottie)
    }

    object DetektPlugins {
        const val composeRules = "ru.kode:detekt-rules-compose:1.2.2"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
        const val workManager = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"

        fun all() = listOf(core, android, compose, workManager)
    }

    object Work {
        const val work = "androidx.work:work-runtime-ktx:${Versions.work}"
    }
}

object Data {

    object Json {
        const val kotlinxSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    }

    object DataStore {
        const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
        const val protoStore = "androidx.datastore:datastore:${Versions.dataStore}"

        const val protobufKotlin = "com.google.protobuf:protobuf-kotlin-lite:3.22.3"
        const val protobufJava = "com.google.protobuf:protobuf-javalite:3.22.3"

        fun all() = listOf(dataStore, protoStore, protobufKotlin, protobufJava)
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.11.0"
    }

    object Firebase {
        const val config = "com.google.firebase:firebase-config-ktx:21.4.1"
    }
}

object General {
    object Date {
        val threeTenBp = "com.jakewharton.threetenabp:threetenabp:1.4.6"
    }
}
