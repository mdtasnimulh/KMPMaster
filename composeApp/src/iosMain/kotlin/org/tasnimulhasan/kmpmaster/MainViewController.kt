package org.tasnimulhasan.kmpmaster

import androidx.compose.ui.window.ComposeUIViewController
import org.tasnimulhasan.kmpmaster.di.initKoin
import org.tasnimulhasan.kmpmaster.ui.KMPMasterApp

fun MainViewController() = ComposeUIViewController {
    initKoin()
    KMPMasterApp()
}