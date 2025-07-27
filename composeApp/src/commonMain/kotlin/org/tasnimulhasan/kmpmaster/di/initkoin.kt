package org.tasnimulhasan.kmpmaster.di

import com.tasnimulhasan.datastore.dataStoreModule
import com.tasnimulhasan.home.homeModule
import com.tasnimulhasan.kmpmaster.di.dataModule
import com.tasnimulhasan.kmpmaster.domain.di.domainModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(
    config: (KoinApplication.() -> Unit)? = null
) {
    startKoin {
        config?.invoke(this)

        modules(
            appModule,
            dataModule,
            domainModule,
            dataStoreModule,
            homeModule,
        )
    }
}