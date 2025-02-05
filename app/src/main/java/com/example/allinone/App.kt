package com.example.allinone

import android.app.Application
import android.content.res.Resources
import com.example.allinone.di.AppModule
import com.example.allinone.di.AppModuleImpl

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appResources = resources
        appModule = AppModuleImpl(this)
    }

    companion object {
        var appResources: Resources? = null
            private set
        lateinit var appModule: AppModule
    }
}