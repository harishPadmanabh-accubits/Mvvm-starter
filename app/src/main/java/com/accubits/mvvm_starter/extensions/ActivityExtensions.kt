package com.accubits.mvvm_starter.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.accubits.mvvm_starter.utils.Injection
import timber.log.Timber
import java.lang.Exception

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this).get(viewModelClass)

fun <T : ViewModel> AppCompatActivity.obtainViewModelWithFactory(viewModelClass: Class<T>) =
        ViewModelProviders.of(this,
                Injection.provideViewModelFactory(application!!, applicationContext)).get(viewModelClass)

fun AppCompatActivity.doLogWithTag(tag:String,message:String,type:LoggingKeys = LoggingKeys.ERROR){
    try{
        when(type){
            LoggingKeys.DEBUG->Timber.tag(tag).d(message)
            LoggingKeys.ERROR->Timber.tag(tag).e(message)
            LoggingKeys.INFO->Timber.tag(tag).i(message)
        }
    }catch (e:Exception){
          Timber.e("Caught in doLogWithTag $e")
    }
}

enum class LoggingKeys{
    DEBUG,INFO,ERROR
}