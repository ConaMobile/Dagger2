package com.conamobile.dagger2

import android.app.Application
import com.conamobile.dagger2.di.component.AppComponent
import com.conamobile.dagger2.di.component.DaggerAppComponent
import com.conamobile.dagger2.di.module.DatabaseModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }
}