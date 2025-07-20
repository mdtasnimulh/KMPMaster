plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform") {
            id = libs.plugins.kmpmaster.kotlinMultiplatform.get().pluginId
            implementationClass = "KotlinMultiplatformConventionPlugin"
        }

        register("androidLibrary") {
            id = libs.plugins.kmpmaster.androidLibrary.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("domainModule") {
            id = libs.plugins.kmpmaster.domainModule.get().pluginId
            implementationClass = "DomainModuleConventionPlugin"
        }

        register("dataModule") {
            id = libs.plugins.kmpmaster.dataModule.get().pluginId
            implementationClass = "DataModuleConventionPlugin"
        }

        register("featureModule") {
            id = libs.plugins.kmpmaster.featureModule.get().pluginId
            implementationClass = "FeatureModuleConventionPlugin"
        }

        register("jvmLibrary") {
            id = "kmpmaster.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}