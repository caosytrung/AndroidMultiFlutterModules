package com.trungcs.multifluttersintoandroid.flutter.first_module

import com.trungcs.multifluttersintoandroid.flutter.second_module.FlutterSecondModule
import dagger.hilt.android.AndroidEntryPoint
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import javax.inject.Inject

@AndroidEntryPoint
class FlutterFirstModuleActivity: FlutterActivity() {
    private var mainChannel: MethodChannel? = null

    @Inject
    val firstModule = FlutterFirstModule.getInstance()

    @Inject
    lateinit var flutterSecondModule: FlutterSecondModule

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        mainChannel =
            MethodChannel(flutterEngine.dartExecutor.binaryMessenger, firstModule.getChannelName())
        mainChannel?.setMethodCallHandler { call, result ->
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