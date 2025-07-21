import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import kotlin.jvm.java

plugins {
    alias(libs.plugins.kmpmaster.featureModule)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {

        }

        commonMain.dependencies {
            implementation(projects.ui.core)
            implementation(projects.shared.domain)
            api(libs.koin.annotations)
        }

        desktopMain.dependencies {
            
        }
    }

    sourceSets.named("commonMain").configure {
        kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
    }
}

ksp {
    arg("KOIN_USE_COMPOSE_VIEWMODEL","true")
    arg("KOIN_CONFIG_CHECK","true")
}

dependencies {
    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
}

project.tasks.withType(KotlinCompilationTask::class.java).configureEach {
    if(name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}