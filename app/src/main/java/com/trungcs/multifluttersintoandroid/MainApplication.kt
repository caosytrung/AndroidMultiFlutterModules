package com.trungcs.multifluttersintoandroid

import android.app.Application
import com.trungcs.multifluttersintoandroid.flutter.first_module.FlutterFirstModule
import com.trungcs.multifluttersintoandroid.flutter.second_module.FlutterSecondModule
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    lateinit var flutterFirstModule: FlutterFirstModule

    @Inject
    lateinit var flutterSecondModule: FlutterSecondModule

    override fun onCreate() {
        super.onCreate()
        warmUpFlutterEngine() // to help opening Flutter Screen faster
    }

    private fun warmUpFlutterEngine() {
        flutterFirstModule.initEngine(this)
        flutterSecondModule.initEngine(this)
    }
}