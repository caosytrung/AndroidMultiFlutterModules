package com.trungcs.multifluttersintoandroid

import android.app.Application
import com.trungcs.multifluttersintoandroid.flutter.first_module.FlutterFirstModule
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    lateinit var flutterFirstModule: FlutterFirstModule

    override fun onCreate() {
        super.onCreate()
        warmUpFlutterEngine() // to help opening Flutter Screen faster
    }

    private fun warmUpFlutterEngine() {
        flutterFirstModule.initEngine(this)
    }
}