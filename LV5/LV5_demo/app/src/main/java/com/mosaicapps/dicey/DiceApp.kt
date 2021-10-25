package com.mosaicapps.dicey

import android.app.Application
import com.mosaicapps.dicey.di.appModule
import com.mosaicapps.dicey.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DiceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DiceApp)
            modules(appModule, viewModelModule)
        }
    }

}