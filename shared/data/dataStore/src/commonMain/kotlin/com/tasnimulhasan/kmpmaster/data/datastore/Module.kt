package com.tasnimulhasan.kmpmaster.data.datastore

import com.tasnimulhasan.kmpmaster.data.datastore.storage.DataStoreStorage
import com.tasnimulhasan.kmpmaster.data.datastore.storage.Storage
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataStoreModule = module {
    includes(platformModule)
    singleOf(::DataStoreStorage) {
        bind<Storage>()
    }
}

internal expect val platformModule: Module
