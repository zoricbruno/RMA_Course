package hr.mosaicapps.animalcounter

import android.app.Application
import android.content.Context
import hr.mosaicapps.animalcounter.di.appModule
import hr.mosaicapps.animalcounter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AnimalCounterApp: Application() {

    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin{
            androidContext(this@AnimalCounterApp)
            modules(appModule, viewModelModule)
        }
    }
}