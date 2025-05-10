package dev.sahildesai.bookhunt

import android.app.Application
import dev.sahildesai.bookhunt.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidContext(this@BookApplication)
        }
    }
}