import com.tasnimulhasan.kmpmaster.getLibs
import org.gradle.api.Plugin
import org.gradle.api.Project

class DomainModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        val libs = getLibs()
        plugins.apply(libs.findPlugin("kmpmaster.kotlinMultiplatform").get().get().pluginId)
    }
}