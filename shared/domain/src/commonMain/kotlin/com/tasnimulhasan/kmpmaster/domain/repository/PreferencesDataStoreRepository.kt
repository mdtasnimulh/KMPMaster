package com.tasnimulhasan.kmpmaster.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferencesDataStoreRepository {

    suspend fun isFirstLaunch(isFirstLaunch: Boolean)
    fun getIsFirstLaunch(): Flow<Boolean>

}