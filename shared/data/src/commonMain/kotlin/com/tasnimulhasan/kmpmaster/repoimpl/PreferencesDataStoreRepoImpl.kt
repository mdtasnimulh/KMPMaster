package com.tasnimulhasan.kmpmaster.repoimpl

import com.tasnimulhasan.kmpmaster.data.datastore.storage.Storage
import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single

@Single
class PreferencesDataStoreRepoImpl(
    @Provided private val storage: Storage,
) : PreferencesDataStoreRepository {

    override suspend fun isFirstLaunch(isFirstLaunch: Boolean) {
        storage.writeValue(IsFirstLaunchKey, isFirstLaunch)
    }

    override fun getIsFirstLaunch(): Flow<Boolean> = storage.getAsFlow(IsFirstLaunchKey)
        .map { it ?: false }

    data object IsFirstLaunchKey : Storage.Key.BooleanKey("isFirstLaunch", false)
}
