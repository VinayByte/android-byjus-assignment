package com.vinay.byjus.di


import com.vinay.byjus.App
import com.vinay.byjus.ui.home.HeadlinesActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, DataModule::class])
interface ApplicationComponent {
    fun inject(app: App)
    fun inject(headlinesActivity: HeadlinesActivity)
}