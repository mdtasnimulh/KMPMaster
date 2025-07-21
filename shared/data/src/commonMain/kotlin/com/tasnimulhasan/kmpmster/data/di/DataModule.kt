package com.tasnimulhasan.kmpmster.data.di

import com.tasnimulhasan.kmpmaster.data.datastore.dataStoreModule
import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import com.tasnimulhasan.kmpmster.data.repoimpl.PreferencesDataStoreRepoImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    includes(dataStoreModule)

    singleOf(::PreferencesDataStoreRepoImpl) {
        bind<PreferencesDataStoreRepository>()
    }
}