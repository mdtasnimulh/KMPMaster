plugins {
    alias(libs.plugins.kmpmaster.dataModule)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.dataStore)
            implementation(projects.shared.domain)

            implementation(libs.datastore.preferences.core)
            implementation(libs.bundles.kotlin)
            implementation(libs.bundles.ktor)
        }
    }
}