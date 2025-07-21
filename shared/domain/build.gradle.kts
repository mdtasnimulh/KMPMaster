plugins {
    alias(libs.plugins.kmpmaster.domainModule)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.dataStore)

            implementation(libs.datastore.preferences.core)
            implementation(libs.bundles.kotlin)
            implementation(libs.bundles.ktor)
        }
    }
}