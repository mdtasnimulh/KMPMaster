plugins {
    alias(libs.plugins.kmpmaster.featureModule)
}

kotlin {
    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {

        }

        commonMain.dependencies {
            implementation(projects.ui.core)
            implementation(compose.components.resources)
        }

        desktopMain.dependencies {

        }
    }
}
