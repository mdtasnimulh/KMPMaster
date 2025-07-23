package org.tasnimulhasan.kmpmaster.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

fun initKoin(
    config: KoinAppDeclaration = {}
) {
    startKoin {
        config.invoke(this)

        modules(
            AppModule().module,
        )
    }
}