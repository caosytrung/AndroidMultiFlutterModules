package com.trungcs.multifluttersintoandroid.flutter.first_module

import android.app.Application
import android.content.Context
import android.content.Intent
import com.trungcs.multifluttersintoandroid.flutter.base.FlutterModule
import io.flutter.FlutterInjector
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class FlutterFirstModule private constructor() : FlutterModule {
    private lateinit var flutterEngine: FlutterEngine
    private var callBack: FlutterFirstModuleCallEvents? = null
    private lateinit var methodChannel: MethodChannel

    override fun initEngine(application: Application) {
        flutterEngine = FlutterEngine(application)
        flutterEngine.navigationChannel.setInitialRoute("/")
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint(
                FlutterInjector.instance().flutterLoader().findAppBundlePath(), ENTRY_POINT
            )
        )
        FlutterEngineCache
            .getInstance()
            .put(ENGINE_ID, flutterEngine)
        methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, getChannelName())
    }

    fun handleEventFromFlutter() {

    }

    fun setCallBack(callBack: FlutterFirstModuleCallEvents?) {
        this.callBack = callBack
    }

    override fun buildWithCachedEngine(context: Context): Intent {
        return FlutterActivity.CachedEngineIntentBuilder(
            FlutterFirstModuleActivity::class.java,
            getEngine()
        ).build(context).apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
    }

    override fun buildWithNewEngine(context: Context): Intent {
        return FlutterActivity.NewEngineIntentBuilder(FlutterFirstModuleActivity::class.java)
            .build(context)
    }

    override fun getChannelName() = CHANNEL_NAME
    override fun getEntryPoint() = ENTRY_POINT
    override fun getEngine() = ENGINE_ID

    companion object {
        private const val CHANNEL_NAME = "FlutterFirstModuleChanel"
        private const val ENTRY_POINT = "firstModule"
        private const val ENGINE_ID = "firstModule"

        private lateinit var firstModule: FlutterFirstModule

        fun getInstance(): FlutterFirstModule {
            if (!::firstModule.isInitialized) {
                firstModule = FlutterFirstModule()
            }

            return firstModule
        }
    }

}