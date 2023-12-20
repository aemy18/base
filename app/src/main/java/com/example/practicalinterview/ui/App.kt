package com.example.practicalinterview.ui

import android.app.Application
import com.example.practicalinterview.ui.di.components.DaggerApplicationComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.factory().create(this).inject(this)
    }
}