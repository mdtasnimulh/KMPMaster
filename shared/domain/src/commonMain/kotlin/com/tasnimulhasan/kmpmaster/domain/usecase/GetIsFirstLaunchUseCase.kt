package com.tasnimulhasan.kmpmaster.domain.usecase

import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single

@Single
class GetIsFirstLaunchUseCase(
    @Provided private val repository: PreferencesDataStoreRepository
) {
    operator fun invoke(): Flow<Boolean> = repository.getIsFirstLaunch()
}