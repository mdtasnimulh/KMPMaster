package com.tasnimulhasan.kmpmaster.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferencesDataStoreRepository {

    suspend fun isFirstLaunch(isFirstLaunch: String)
    fun getIsFirstLaunch(): Flow<String>

}