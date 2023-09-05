package com.mightyhedgehog.clicker.app

import android.app.Application
import com.mightyhedgehog.clicker.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(AppModule)
        }
    }
}
