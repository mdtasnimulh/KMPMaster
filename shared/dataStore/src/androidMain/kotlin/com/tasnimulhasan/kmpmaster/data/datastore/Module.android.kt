package com.tasnimulhasan.kmpmaster.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.tasnimulhasan.kmpmaster.data.datastore.storage.createDataStore
import org.koin.dsl.module

internal actual val platformModule = module {
    single<DataStore<Preferences>> {
        createDataStore(context = get())
    }
}