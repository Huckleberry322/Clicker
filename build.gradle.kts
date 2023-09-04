buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detekt}")
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.9.3")
        classpath("com.google.gms:google-services:4.3.15")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt").version(Versions.detekt)
    id("org.jetbrains.kotlin.android") version Versions.kotlin apply false
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = AppBuildConfig.Java.toString()
        }
    }
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        config = files("${rootDir}/detekt.yml")

        allRules = true
        buildUponDefaultConfig = true

        source = files(
            "src/main/java",
        )
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}