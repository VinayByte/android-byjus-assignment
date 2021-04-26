package com.vinay.byjus

import android.app.Application
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import com.vinay.byjus.di.ApplicationComponent
import com.vinay.byjus.di.ApplicationModule
import com.vinay.byjus.di.DaggerApplicationComponent

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        setupDagger()
        Stetho.initializeWithDefaults(this)

        AndroidThreeTen.init(this);

    }

    private fun setupDagger() {
        applicationComponent =
            DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        applicationComponent.inject(this)
    }

    companion object {
        lateinit var instance: App
            private set
        lateinit var applicationComponent: ApplicationComponent
            private set
    }
}