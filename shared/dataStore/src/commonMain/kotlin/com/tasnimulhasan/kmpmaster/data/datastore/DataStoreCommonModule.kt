package com.tasnimulhasan.kmpmaster.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.tasnimulhasan.kmpmaster.data.datastore.storage.DataStoreStorage
import com.tasnimulhasan.kmpmaster.data.datastore.storage.Storage
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

/*val dataStoreModule = module {
    includes(platformModule)
    singleOf(::DataStoreStorage) {
        bind<Storage>()
    }
}

internal expect val platformModule: Module*/
@Module
class DataStoreCommonModule {

    @Factory
    fun dataStoreStorage(dataStore: DataStore<Preferences>) = DataStoreStorage(dataStore)

}