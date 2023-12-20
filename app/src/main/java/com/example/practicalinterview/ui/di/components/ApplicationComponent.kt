package com.example.practicalinterview.ui.di.components

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.practicalinterview.ui.App
import com.example.practicalinterview.ui.LoginActivity
import com.example.practicalinterview.ui.di.core.Session
import com.example.practicalinterview.ui.di.modules.ApplicationModule
import com.example.practicalinterview.ui.di.modules.NetModule
import com.example.practicalinterview.ui.di.modules.ViewModelModule
import com.example.practicalinterview.ui.di.repository.UserRepository
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetModule::class, ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun context(): Context
    fun inject(app: App)
    fun inject(loginActivity: LoginActivity)
    fun provideRepository(): UserRepository
    fun providerSession():Session
    fun providerGson():Gson

    fun provideViewModelFactory(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}