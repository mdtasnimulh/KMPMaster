package org.tasnimulhasan.kmpmaster

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.tasnimulhasan.kmpmaster.ui.KMPMasterApp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP Master",
    ) {
        KMPMasterApp()
    }
}