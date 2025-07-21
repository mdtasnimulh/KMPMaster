package org.tasnimulhasan.kmpmaster

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.tasnimulhasan.kmpmaster.di.initKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApp)
        }
    }
}