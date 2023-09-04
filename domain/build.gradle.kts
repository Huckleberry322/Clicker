plugins {
    id("kotlin")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = AppBuildConfig.Java
    targetCompatibility = AppBuildConfig.Java
}

dependencies {
    detektPlugins(App.DetektPlugins.composeRules)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation(General.Date.threeTenBp)
}