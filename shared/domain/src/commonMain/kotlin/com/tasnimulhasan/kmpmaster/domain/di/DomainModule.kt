package com.tasnimulhasan.kmpmaster.domain.di

import com.tasnimulhasan.kmpmaster.data.datastore.dataStoreModule
import com.tasnimulhasan.kmpmaster.domain.usecase.GetIsFirstLaunchUseCase
import com.tasnimulhasan.kmpmaster.domain.usecase.SetIsFirstLaunchUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    //includes(dataStoreModule)

    factoryOf(::SetIsFirstLaunchUseCase)
    factoryOf(::GetIsFirstLaunchUseCase)
}