package com.example.coroutinelab

import android.app.Application
import com.example.data.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Myapplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.DEBUG)

            // AndroidContext: Provide the Android Application context to Koin
            // This is crucial for Koin modules that need context (e.g., for Room, SharedPreferences)
            androidContext(this@Myapplication)

            modules(
                NetworkModule
            )
        }
    }
}
