package com.trungcs.multifluttersintoandroid.di

import com.trungcs.multifluttersintoandroid.flutter.first_module.FlutterFirstModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FlutterModule {
    @Provides
    fun provideFirstFlutterModule(): FlutterFirstModule {
        return FlutterFirstModule.getInstance()
    }
}