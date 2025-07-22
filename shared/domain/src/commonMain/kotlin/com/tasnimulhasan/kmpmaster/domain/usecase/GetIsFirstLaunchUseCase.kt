package com.tasnimulhasan.kmpmaster.domain.usecase

import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

class GetIsFirstLaunchUseCase(
    private val repository: PreferencesDataStoreRepository
) {
    operator fun invoke(): Flow<Boolean> = repository.getIsFirstLaunch()
}