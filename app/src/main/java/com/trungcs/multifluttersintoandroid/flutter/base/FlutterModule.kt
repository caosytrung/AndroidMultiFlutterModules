package com.trungcs.multifluttersintoandroid.flutter.base

import android.app.Application

interface FlutterModule {
    fun initEngine(application: Application)
}