package com.tasnimulhasan.kmpmaster.domain.usecase

import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository

class GetIsFirstLaunchUseCase(
    private val repository: PreferencesDataStoreRepository
) {
    operator fun invoke() = repository.getIsFirstLaunch()
}