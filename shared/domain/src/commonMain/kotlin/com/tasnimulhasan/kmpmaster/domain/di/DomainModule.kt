package com.tasnimulhasan.kmpmaster.domain.di

import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import com.tasnimulhasan.kmpmaster.domain.usecase.GetIsFirstLaunchUseCase
import com.tasnimulhasan.kmpmaster.domain.usecase.SetIsFirstLaunchUseCase
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class DomainModule {

    @Factory(binds = [PreferencesDataStoreRepository::class])
    fun provideGetIsFirstLaunchUseCase(repository: PreferencesDataStoreRepository): GetIsFirstLaunchUseCase {
        return GetIsFirstLaunchUseCase(repository)
    }

    @Factory(binds = [PreferencesDataStoreRepository::class])
    fun provideSetIsFirstLaunchUseCase(repository: PreferencesDataStoreRepository): SetIsFirstLaunchUseCase {
        return SetIsFirstLaunchUseCase(repository)
    }

}