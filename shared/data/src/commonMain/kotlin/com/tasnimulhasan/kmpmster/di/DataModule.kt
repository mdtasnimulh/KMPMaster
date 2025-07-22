package com.tasnimulhasan.kmpmster.di

import com.tasnimulhasan.kmpmaster.data.datastore.storage.Storage
import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import com.tasnimulhasan.kmpmster.repoimpl.PreferencesDataStoreRepoImpl
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class DataModule {

    /*@Factory
    fun providePreferenceDataStoreRepository(storage: Storage): PreferencesDataStoreRepository {
        return PreferencesDataStoreRepoImpl(storage)
    }*/

}