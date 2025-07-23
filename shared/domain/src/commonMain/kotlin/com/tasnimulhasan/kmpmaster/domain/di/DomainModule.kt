package com.tasnimulhasan.kmpmaster.domain.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("com.tasnimulhasan.kmpmaster.domain")
class DomainModule {

    /*@Factory(binds = [PreferencesDataStoreRepository::class])
    fun provideSetIsFirstLaunchUseCase(repository: PreferencesDataStoreRepository): SetIsFirstLaunchUseCase {
        return SetIsFirstLaunchUseCase(repository)
    }*/

}