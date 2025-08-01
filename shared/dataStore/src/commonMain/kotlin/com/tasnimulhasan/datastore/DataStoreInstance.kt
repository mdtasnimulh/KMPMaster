package com.tasnimulhasan.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.SynchronizedObject
import kotlinx.coroutines.internal.synchronized
import okio.Path.Companion.toPath

@OptIn(InternalCoroutinesApi::class)
private val lock = SynchronizedObject()
private lateinit var dataStore: DataStore<Preferences>

@OptIn(InternalCoroutinesApi::class)
fun createDataStore(
    producePath: () -> String
): DataStore<Preferences> {
    return synchronized(lock) {
        if (::dataStore.isInitialized) {
            dataStore
        } else {
            PreferenceDataStoreFactory.createWithPath(
                produceFile = {
                    producePath().toPath()
                }
            ).also { dataStore = it }
        }
    }
}

internal const val DATA_STORE_FILE_NAME = "kmpmaster_storage.preferences_pb"