package hr.ferit.taskie

import android.app.Application
import hr.ferit.taskie.di.databaseModule
import hr.ferit.taskie.di.repositoryModule
import hr.ferit.taskie.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Taskie: Application() {

    override fun onCreate() {
        super.onCreate()
        application = this

        startKoin{
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@Taskie)
            modules(
                databaseModule,
                repositoryModule,
                viewmodelModule
            )
        }

    }

    companion object{
        lateinit var application: Application
    }
}