package com.trungcs.multifluttersintoandroid.flutter.base

import android.app.Application
import android.content.Context
import android.content.Intent

interface FlutterModule {
    fun initEngine(application: Application)

    fun buildWithCachedEngine(context: Context): Intent
    fun buildWithNewEngine(context: Context): Intent

    fun getChannelName(): String
    fun getEntryPoint(): String
    fun getEngine(): String
}