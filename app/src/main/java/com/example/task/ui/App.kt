package com.example.task.ui

import android.app.Application
import com.example.task.di.appModule
import com.example.task.di.mainModule
import com.example.task.di.noteModule
import com.example.task.di.splashModule
import org.koin.android.ext.android.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}