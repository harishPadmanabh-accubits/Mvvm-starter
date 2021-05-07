package com.accubits.mvvm_starter.utils

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider

object Injection {

    fun provideViewModelFactory(application: Application, context: Context): ViewModelProvider.Factory {
        return CustomViewModelFactory(application)
    }
}