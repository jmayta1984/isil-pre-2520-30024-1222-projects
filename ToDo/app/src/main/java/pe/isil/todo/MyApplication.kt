package pe.isil.todo

import android.app.Application

class MyApplication: Application() {
    companion object {
        lateinit var INSTANCE: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}