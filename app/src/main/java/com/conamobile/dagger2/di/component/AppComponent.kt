package com.conamobile.dagger2.di.component

import com.conamobile.dagger2.MainActivity
import com.conamobile.dagger2.di.module.DatabaseModule
import com.conamobile.dagger2.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}