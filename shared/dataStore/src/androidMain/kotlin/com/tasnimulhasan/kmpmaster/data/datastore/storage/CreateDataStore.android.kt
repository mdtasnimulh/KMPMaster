package com.tasnimulhasan.kmpmaster.data.datastore.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

actual fun createDataStore(context: Any?): DataStore<Preferences> {

    return createDataStore {
        (context as Context)
            .filesDir
            .resolve(dataStoreFileName)
            .absolutePath
    }

}