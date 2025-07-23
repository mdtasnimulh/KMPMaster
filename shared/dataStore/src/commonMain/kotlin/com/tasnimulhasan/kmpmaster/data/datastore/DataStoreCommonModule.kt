package com.tasnimulhasan.kmpmaster.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.tasnimulhasan.kmpmaster.data.datastore.storage.createDataStore
import com.tasnimulhasan.kmpmaster.data.datastore.storage.dataStoreFileName
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.tasnimulhasan.kmpmaster.data.datastore")
class DataStoreCommonModule {

    init {
        platformModule
    }

    @Single
    fun provideDataStore(): DataStore<Preferences> {
        return createDataStore {
            dataStoreFileName
        }
    }

}