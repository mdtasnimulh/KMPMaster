import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.FileInputStream
import java.util.Properties
import kotlin.apply

plugins {
    alias(libs.plugins.kmpmaster.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
}

val versionPropertiesInputStream = FileInputStream("$rootDir/versions.properties")
val versionProperties = Properties().apply {
    load(versionPropertiesInputStream)
}
val versionCodeProperty = versionProperties.getProperty("versionCode").toInt()
val versionMajorProperty = versionProperties.getProperty("versionMajor").toInt()
val versionMinorProperty = versionProperties.getProperty("versionMinor").toInt()
val versionPatchProperty = versionProperties.getProperty("versionPatch").toInt()

val versionNameProperty = "$versionMajorProperty.$versionMinorProperty.$versionPatchProperty"

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {

        }
        commonMain.dependencies {
            implementation(projects.shared.dataStore)

            implementation(projects.ui.core)
            implementation(projects.feature.home)
            implementation(projects.feature.profile)

            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.koin.core)
            implementation(libs.bundles.koin.compose)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        desktopMain.dependencies {

        }
    }
}

android {
    namespace = "org.tasnimulhasan.kmpmaster"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.tasnimulhasan.kmpmaster"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = versionCodeProperty
        versionName = versionNameProperty
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "org.tasnimulhasan.kmpmaster.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KMPMaster"
            packageVersion = versionNameProperty
            description = "KMPMaster by Tasnimul Hasan"
            copyright = "Copyright (c) 2025, Tasnimul Hasan"
            licenseFile.set(project.file("../LICENSE.txt"))

            macOS {
                dockName = "KMPMaster"
                entitlementsFile.set(project.file("default.entitlements"))
            }
        }

        buildTypes.release {
            proguard {
                obfuscate.set(true)
                configurationFiles.from("proguard-rules.pro")
            }
        }
    }
}
