plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.serialization)
    alias(libs.plugins.publish)
}

kotlin {
    jvmToolchain(17)
    jvm()
    js {
        browser()
        binaries.executable()
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "slog"
            isStatic = true
        }
    }

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
}

tasks.named("sourcesJar") {
    dependsOn("kspCommonMainKotlinMetadata")
}