package com.trungcs.multifluttersintoandroid.flutter.first_module

import com.trungcs.multifluttersintoandroid.flutter.second_module.FlutterSecondModule
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class FlutterFirstModuleActivity : FlutterActivity() {
    // can not use DI here because the FlutterActivity is not a subclass of android.activity
    private val flutterSecondModule = FlutterSecondModule.getInstance()
    private val flutterFirstModule = FlutterFirstModule.getInstance()

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        val mainChannel =
            MethodChannel(
                flutterEngine.dartExecutor.binaryMessenger,
                flutterFirstModule.getChannelName()
            )
        mainChannel.setMethodCallHandler { call, result ->
            // Note: this method is invoked on the main thread.
            when (call.method) {
                FINISH_EVENT -> {
                    this.finish()
                }

                OPEN_SECOND_MODULE_EVENT -> {
                    startActivity(flutterSecondModule.buildWithCachedEngine(this))
                }

                else -> {
                    result.notImplemented()
                }
            }
        }
    }

    companion object {
        private const val FINISH_EVENT = "finishEvent"
        private const val OPEN_SECOND_MODULE_EVENT = "openSecondModuleEvent"
    }
}