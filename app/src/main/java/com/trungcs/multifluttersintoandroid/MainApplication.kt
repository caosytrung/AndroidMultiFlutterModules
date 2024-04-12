package com.trungcs.multifluttersintoandroid

import android.app.Application

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        warmUpFlutterEngine() // to help opening Flutter Screen faster
    }

    private fun warmUpFlutterEngine() {

    }
}