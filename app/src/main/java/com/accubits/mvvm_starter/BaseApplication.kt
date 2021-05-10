package com.accubits.mvvm_starter

import android.app.Application
import com.accubits.mvvm_starter.data.AppDataHandler
import timber.log.Timber

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())

        //set launch time
        AppDataHandler.init(this).setLastLaunchTime(System.currentTimeMillis())


    }
}