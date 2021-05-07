package com.accubits.mvvm_starter.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.accubits.mvvm_starter.utils.Injection

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this).get(viewModelClass)

fun <T : ViewModel> AppCompatActivity.obtainViewModelWithFactory(viewModelClass: Class<T>) =
        ViewModelProviders.of(this,
                Injection.provideViewModelFactory(application!!, applicationContext)).get(viewModelClass)
