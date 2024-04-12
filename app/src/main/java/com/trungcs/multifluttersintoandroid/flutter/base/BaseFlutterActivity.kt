package com.trungcs.multifluttersintoandroid.flutter.base

import io.flutter.embedding.android.FlutterActivity

abstract class BaseFlutterActivity: FlutterActivity() {
    abstract fun getChannelName(): String
    abstract fun getEntryPoint(): String
    abstract fun getEngine(): String
}