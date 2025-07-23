package com.tasnimulhasan.kmpmaster.di

import com.tasnimulhasan.kmpmaster.data.datastore.storage.Storage
import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import com.tasnimulhasan.kmpmaster.repoimpl.PreferencesDataStoreRepoImpl
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.tasnimulhasan.kmpmaster.data")
class DataModule {

    @Single
    fun providePreferenceDataStoreRepository(storage: Storage): PreferencesDataStoreRepository {
        return PreferencesDataStoreRepoImpl(storage)
    }

}