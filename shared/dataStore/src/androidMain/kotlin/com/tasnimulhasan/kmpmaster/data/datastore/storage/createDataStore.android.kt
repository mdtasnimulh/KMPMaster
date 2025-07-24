package com.tasnimulhasan.kmpmaster.data.datastore.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

fun createDataStore(
    context: Context,
): DataStore<Preferences> {
    return PreferenceDataStoreFactory.create(
        scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
        produceFile = {
            context.preferencesDataStoreFile(dataStoreFileName)
        }
    )
}
/*fun createDataStore(
    context: Context,
): DataStore<Preferences> = createDataStore(
    producePath = {
        context.filesDir.resolve(dataStoreFileName).absolutePath
    }
)*/