import com.android.build.gradle.LibraryExtension
import com.tasnimulhasan.kmpmaster.getLibs
import com.tasnimulhasan.kmpmaster.modulePackageName
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()
        plugins.apply(libs.findPlugin("androidLibrary").get().get().pluginId)

        extensions.configure<LibraryExtension> {
            namespace = "org.tasnimulhasan.kmpmaster.$modulePackageName"
            compileSdk = libs.findVersion("android.compileSdk").get().requiredVersion.toInt()

            defaultConfig {
                minSdk = libs.findVersion("android.minSdk").get().requiredVersion.toInt()
            }

            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false //true
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
    }
}