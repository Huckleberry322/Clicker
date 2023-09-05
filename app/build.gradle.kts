@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("io.gitlab.arturbosch.detekt")
}

android {
    namespace = AppBuildConfig.PackageName
    compileSdk = AppBuildConfig.CompileSDK

    signingConfigs {
        getByName("debug") {
            storeFile = file("clicker.jks")
            storePassword = "xclickerx1223"
            keyAlias = "clicker"
            keyPassword = "xclickerx1224"
        }
        create("release") {
            storeFile = file("clicker.jks")
            storePassword = "xclickerx1223"
            keyAlias = "clicker"
            keyPassword = "xclickerx1224"
        }
    }

    defaultConfig {
        applicationId = AppBuildConfig.PackageName
        minSdk = AppBuildConfig.MinSDK
        targetSdk = AppBuildConfig.TargetSDK
        versionCode = AppBuildConfig.VersionCode
        versionName = AppBuildConfig.VersionName
        vectorDrawables {
            useSupportLibrary = true
        }

        testInstrumentationRunner = ("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = AppBuildConfig.Java
        targetCompatibility = AppBuildConfig.Java
    }
    kotlinOptions {
        jvmTarget = AppBuildConfig.Java.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    App.Base.all().forEach(::implementation)

    App.Compose.base().forEach(::implementation)
    App.Compose.debug().forEach(::debugImplementation)
    App.Accompanist.all().forEach(::implementation)

    App.Images.all().forEach(::implementation)
    App.Animation.all().forEach(::implementation)

    App.Koin.all().forEach(::implementation)

    implementation(General.Date.threeTenBp)

    implementation(App.Work.work)

    implementation(General.Date.threeTenBp)

    detektPlugins(App.DetektPlugins.composeRules)

    implementation(project(":data"))
    implementation(project(":domain"))
}