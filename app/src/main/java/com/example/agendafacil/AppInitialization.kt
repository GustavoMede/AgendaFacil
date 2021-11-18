package com.example.agendafacil

import android.app.Application
import com.example.agendafacil.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AppInitialization: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@AppInitialization)
            modules(appModules)
        }
    }
}