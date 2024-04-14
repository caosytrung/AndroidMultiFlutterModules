package com.trungcs.multifluttersintoandroid.flutter.second_module

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class FlutterSecondModuleActivity: FlutterActivity() {
    private val flutterSecondModule = FlutterSecondModule.getInstance()
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val mainChannel =
            MethodChannel(
                flutterEngine.dartExecutor.binaryMessenger,
                flutterSecondModule.getChannelName()
            )
        mainChannel.setMethodCallHandler { call, result ->
            // Note: this method is invoked on the main thread.
            when (call.method) {
                FINISH_EVENT -> {
                    this.finish()
                }

                else -> {
                    result.notImplemented()
                }
            }
        }
    }

    companion object {
        private const val FINISH_EVENT = "finishEvent"
    }
}