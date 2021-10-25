package hr.mosaicapps.notesy

import android.app.Application

class Notesy : Application() {

    companion object{
        lateinit var application: Notesy
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}