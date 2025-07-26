package com.tasnimulhasan.kmpmaster.domain.di

import com.tasnimulhasan.kmpmaster.domain.usecase.GetIsFirstLaunchUseCase
import com.tasnimulhasan.kmpmaster.domain.usecase.SetIsFirstLaunchUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetIsFirstLaunchUseCase(get()) }
    factory { SetIsFirstLaunchUseCase(get()) }
}