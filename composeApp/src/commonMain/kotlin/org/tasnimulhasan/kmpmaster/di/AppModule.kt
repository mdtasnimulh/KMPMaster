package org.tasnimulhasan.kmpmaster.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.tasnimulhasan.kmpmaster.ui.KmpMasterViewModel

val appModule = module {
    viewModel { KmpMasterViewModel(get()) }
}