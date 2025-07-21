plugins {
    alias(libs.plugins.kmpmaster.dataModule)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.datastore.preferences.core)
        }
    }
}