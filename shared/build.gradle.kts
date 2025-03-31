plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktorfit)
    id("convention.publication")
    alias(libs.plugins.serialization)
}

group = "io.github.theapache64.slog"
version = "1.0.0"

kotlin {
    jvmToolchain(17)

    androidTarget { publishLibraryVariants("release") }
    jvm()
    js { browser() }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktorfit)
            implementation(libs.retrosheet)
            implementation(libs.ktor.core)
            implementation(libs.coroutines.core)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compileTaskProvider.configure {
            compilerOptions {
                freeCompilerArgs.add("-Xexport-kdoc")
            }
        }
    }

}

android {
    namespace = "io.github.theapache64.slog"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
    }
}
