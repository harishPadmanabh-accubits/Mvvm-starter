package com.accubits.mvvm_starter

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import com.accubits.mvvm_starter.data.AppDataHandler
import timber.log.Timber

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //enableStrictMode()
        if(BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())

        //set launch time
        AppDataHandler.init(this).setLastLaunchTime(System.currentTimeMillis())

        //init sdks


    }

    /**
     * Catches ANRs
     */
    private fun enableStrictMode() {
        try {
            if (BuildConfig.DEBUG) {
                StrictMode.setThreadPolicy(
                    StrictMode.ThreadPolicy.Builder()
                        .detectDiskReads()
                        .detectDiskWrites()
                        .detectCustomSlowCalls()
                        .detectNetwork() // or .detectAll() for all detectable problems
                        .penaltyLog()
                        .build()
                )
                StrictMode.setVmPolicy(
                    VmPolicy.Builder()
                        .detectLeakedSqlLiteObjects()
                        .detectLeakedClosableObjects()
                        .penaltyLog() //.penaltyDeath()
                        .build()
                )
            }
        } catch (e: Exception) {
        }
    }

}