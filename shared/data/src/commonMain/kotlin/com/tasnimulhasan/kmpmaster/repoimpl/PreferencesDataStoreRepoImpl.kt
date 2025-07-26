package com.tasnimulhasan.kmpmaster.repoimpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single

@Single
class PreferencesDataStoreRepoImpl(
    private val dataStore: DataStore<Preferences>
) : PreferencesDataStoreRepository {

    private suspend fun tryIt(action: suspend () -> Unit) {
        try {
            action()
        } catch (exception: Exception) {
            println(exception)
        }
    }

    override suspend fun isFirstLaunch(isFirstLaunch: String) {
        tryIt {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.isFirstLaunchKey] = isFirstLaunch
            }
        }
    }

    override fun getIsFirstLaunch(): Flow<String> {
        return dataStore.data.map { preferences ->
            preferences[PreferencesKeys.isFirstLaunchKey] ?: ""
        }
    }

    private object PreferencesKeys {
        val isFirstLaunchKey = stringPreferencesKey(name = "is_first_launch")
    }
}
