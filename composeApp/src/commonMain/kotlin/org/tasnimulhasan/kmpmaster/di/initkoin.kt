package org.tasnimulhasan.kmpmaster.di

import com.tasnimulhasan.home.HomeModule
import com.tasnimulhasan.kmpmaster.data.datastore.DataStoreCommonModule
import com.tasnimulhasan.kmpmaster.domain.di.DomainModule
import com.tasnimulhasan.kmpmster.di.DataModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

fun initKoin(
    config: KoinAppDeclaration? = null
) {
    startKoin {
        config?.invoke(this)

        modules(
            AppModule().module,
            HomeModule().module,
            DataModule().module,
            DomainModule().module,
            DataStoreCommonModule().module,
        )
    }
}