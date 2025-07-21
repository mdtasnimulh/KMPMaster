package com.tasnimulhasan.home

import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import com.tasnimulhasan.kmpmaster.domain.usecase.GetIsFirstLaunchUseCase
import com.tasnimulhasan.kmpmaster.domain.usecase.SetIsFirstLaunchUseCase
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class HomeModule() {
    
    @Factory(binds = [GetIsFirstLaunchUseCase::class])
    fun getIsFirstLaunchUseCase() = GetIsFirstLaunchUseCase()

    @Factory(binds = [SetIsFirstLaunchUseCase::class])
    fun setIsFirstLaunchUseCase() = SetIsFirstLaunchUseCase()

    @KoinViewModel
    fun homeViewModel() = HomeViewModel()

}