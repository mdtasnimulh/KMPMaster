package com.tasnimulhasan.kmpmaster.di

import com.tasnimulhasan.kmpmaster.domain.repository.PreferencesDataStoreRepository
import com.tasnimulhasan.kmpmaster.repoimpl.PreferencesDataStoreRepoImpl
import org.koin.dsl.module

val dataModule = module {
    single<PreferencesDataStoreRepository> { PreferencesDataStoreRepoImpl(get()) }
}