package com.tasnimulhasan.kmpmaster.domain.repository

import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Single

interface PreferencesDataStoreRepository {

    suspend fun isFirstLaunch(isFirstLaunch: Boolean)
    fun getIsFirstLaunch(): Flow<Boolean>

}