package com.trungcs.multifluttersintoandroid

import android.app.Application
import com.trungcs.multifluttersintoandroid.flutter.first_module.FlutterFirstModule
import com.trungcs.multifluttersintoandroid.flutter.second_module.FlutterSecondModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        warmUpFlutterEngine() // to help opening Flutter Screen faster
    }

    private fun warmUpFlutterEngine() {
        FlutterFirstModule.getInstance().preWarmEngine(this)
        FlutterSecondModule.getInstance().preWarmEngine(this)
    }
}