package org.tasnimulhasan.kmpmaster.di

import com.tasnimulhasan.home.HomeModule
import com.tasnimulhasan.kmpmaster.data.datastore.DataStoreCommonModule
import com.tasnimulhasan.kmpmaster.di.DataModule
import com.tasnimulhasan.kmpmaster.domain.di.DomainModule
import org.koin.core.annotation.Module

@Module(
    includes = [
        HomeModule::class,
        DataModule::class,
        DomainModule::class,
        DataStoreCommonModule::class,
    ]
)
class AppModule