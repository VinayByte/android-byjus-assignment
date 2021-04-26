package com.vinay.byjus.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Singleton
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T
}
