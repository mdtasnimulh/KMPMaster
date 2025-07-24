package com.tasnimulhasan.kmpmaster.data.datastore.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import java.io.File

actual fun createDataStore(context: Any?): DataStore<Preferences> {
    val parentFolder = File(System.getProperty("user.dir"))
    if (!parentFolder.exists()) {
        parentFolder.mkdirs()
    }
    val preferencesPath = File(parentFolder, dataStoreFileName)
    return createDataStore(
        producePath = { preferencesPath.absolutePath }
    )
}
