package com.trungcs.multifluttersintoandroid.flutter.second_module

import android.app.Application
import android.content.Context
import android.content.Intent
import com.trungcs.multifluttersintoandroid.flutter.base.FlutterModule
import io.flutter.FlutterInjector
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class FlutterSecondModule private constructor() : FlutterModule {
    private lateinit var flutterEngine: FlutterEngine
    private var callBack: FlutterSecondModuleCallEvents? = null

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
    }

    fun setCallBack(callBack: FlutterSecondModuleCallEvents?) {
        this.callBack = callBack
    }

    override fun buildWithCachedEngine(context: Context): Intent {
        return FlutterActivity.CachedEngineIntentBuilder(
            FlutterSecondModuleActivity::class.java,
            getEngine()
        ).build(context).apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
    }

    override fun buildWithNewEngine(context: Context): Intent {
        return FlutterActivity.NewEngineIntentBuilder(FlutterSecondModuleActivity::class.java)
            .build(context)
    }

    override fun getChannelName() = CHANNEL_NAME
    override fun getEntryPoint() = ENTRY_POINT
    override fun getEngine() = ENGINE_ID

    companion object {
        private const val CHANNEL_NAME = "FlutterSecondModuleChannel"
        private const val ENTRY_POINT = "secondModule"
        private const val ENGINE_ID = "secondModule"

        private lateinit var secondModule: FlutterSecondModule

        fun getInstance(): FlutterSecondModule {
            if (!::secondModule.isInitialized) {
                secondModule = FlutterSecondModule()
            }

            return secondModule
        }
    }

}