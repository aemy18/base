package com.example.practicalinterview.ui.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practicalinterview.ui.ViewModelFactory
import com.example.practicalinterview.ui.di.viewmodels.AuthenticationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @ClassKey(AuthenticationViewModel::class)
    @IntoMap
    abstract fun mainViewModel(authenticationViewModel: AuthenticationViewModel): ViewModel
}