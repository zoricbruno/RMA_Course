package hr.ferit.taskie

import android.app.Application

class Taskie: Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object{
        lateinit var application: Application
    }
}