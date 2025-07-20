package org.tasnimulhasan.kmpmaster

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP Master",
    ) {
        App()
    }
}