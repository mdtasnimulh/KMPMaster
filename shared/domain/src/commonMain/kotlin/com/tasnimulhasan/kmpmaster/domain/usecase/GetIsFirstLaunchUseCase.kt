package com.tasnimulhasan.kmpmaster.domain.usecase

import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single

@Single
class GetIsFirstLaunchUseCase(
    @Provided private val repository: PreferencesDataStoreRepository
) {
    suspend operator fun invoke() = repository.getIsFirstLaunch()
}