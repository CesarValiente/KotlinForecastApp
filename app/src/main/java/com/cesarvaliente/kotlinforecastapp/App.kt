package com.cesarvaliente.kotlinforecastapp

import android.app.Application
import com.cesarvaliente.kotlinforecastapp.ui.utils.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}