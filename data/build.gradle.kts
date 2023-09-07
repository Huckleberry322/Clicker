@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.protobuf")
    kotlin("plugin.serialization") version Versions.kotlin
}

android {
    namespace = AppBuildConfig.DataPackageName
    compileSdk = AppBuildConfig.CompileSDK

    defaultConfig {
        minSdk = AppBuildConfig.MinSDK
        targetSdk = AppBuildConfig.TargetSDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppBuildConfig.Java
        targetCompatibility = AppBuildConfig.Java
    }
    kotlinOptions {
        jvmTarget = AppBuildConfig.Java.toString()
    }

    protobuf {
        protoc {
            artifact = "com.google.protobuf:protoc:3.20.1"
        }

        generateProtoTasks {
            all().forEach {
                it.builtins {
                    create("java") {
                        option("lite")
                    }
                    create("kotlin") {
                        option("lite")
                    }
                }
            }
        }
    }
}

dependencies {
    Data.DataStore.all().forEach(::implementation)
    implementation(General.Date.threeTenBp)
    implementation(Data.Network.retrofit)
    implementation(Data.Network.loggingInterceptor)
    implementation(Data.Json.kotlinxSerialization)
    detektPlugins(General.DetektPlugins.composeRules)
    implementation(Data.Firebase.config)
    implementation(General.Koin.core)
    implementation(General.Koin.android)

    implementation(project(":domain"))
}
