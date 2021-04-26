package com.vinay.byjus.di

import android.app.Application
import android.content.Context
import com.vinay.byjus.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Module
class ApplicationModule(var app: App) {

    @Provides
    @Singleton
    fun provideApp(): Application {
        return app
    }

    @Provides
    @Singleton
    fun getContext(): Context = app

}