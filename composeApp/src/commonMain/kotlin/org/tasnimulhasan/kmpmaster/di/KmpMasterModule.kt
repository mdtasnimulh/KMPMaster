package org.tasnimulhasan.kmpmaster.di

import com.tasnimulhasan.home.homeModule
import org.koin.dsl.module

val kmpMasterModule = module {
    includes(
        homeModule
    )
}