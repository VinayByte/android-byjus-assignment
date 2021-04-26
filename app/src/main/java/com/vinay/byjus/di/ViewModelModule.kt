package com.vinay.byjus.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinay.byjus.ui.HeadlinesRepo
import com.vinay.byjus.ui.HeadlinesViewModel
import com.vinay.byjus.ui.home.HeadlinesDataSource
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
/**
 * Created on 4/26/2021.
 *
 * @author Vinay
 *
 * vinay6kr@gmail.com
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HeadlinesViewModel::class)
    abstract fun provideHeadlinesViewModel(headlinesViewModel: HeadlinesViewModel): ViewModel

    @Binds
    abstract fun headlinesRepo(headlinesRepo: HeadlinesRepo): HeadlinesDataSource
}

