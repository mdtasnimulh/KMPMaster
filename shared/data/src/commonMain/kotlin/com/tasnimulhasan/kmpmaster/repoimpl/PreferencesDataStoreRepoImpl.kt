package com.tasnimulhasan.kmpmaster.repoimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Single

class PreferencesDataStoreRepoImpl(
    private val dataStore: DataStore<Preferences>
) : PreferencesDataStoreRepository {

    override suspend fun isFirstLaunch(isFirstLaunch: String) {
        return withContext(Dispatchers.IO) {
            try {
                dataStore.edit { preferences ->
                    preferences[PreferencesKeys.isFirstLaunchKey] = isFirstLaunch
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun getIsFirstLaunch(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[PreferencesKeys.isFirstLaunchKey] ?: "Y"
        }
    }

    private object PreferencesKeys {
        val isFirstLaunchKey = stringPreferencesKey(name = "is_first_launch")
    }
}
