package com.tasnimulhasan.kmpmaster.domain.usecase

import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository

class SetIsFirstLaunchUseCase(
    private val preferencesDataStoreRepository: PreferencesDataStoreRepository
) {
    suspend fun invoke(isFirstLaunch: String) =
        preferencesDataStoreRepository.isFirstLaunch(isFirstLaunch = isFirstLaunch)
}