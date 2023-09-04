import org.gradle.api.JavaVersion

object AppBuildConfig {
    const val CompileSDK = 34
    const val MinSDK = 24
    const val VersionCode = 1
    const val VersionName = "0.28"
    const val TargetSDK = 34

    const val PackageName = "com.mightyhedgehog.clicker"
    const val DataPackageName = "com.mightyhedgehog.data.clicker"

    val Java = JavaVersion.VERSION_17
}
