package com.accubits.mvvm_starter.data

import android.content.Context
import android.content.SharedPreferences
import com.accubits.mvvm_starter.R
import com.accubits.mvvm_starter.extensions.putAny

/**
 * Handles all shared preferences data
 */

object AppDataHandler {
    private var preferences: SharedPreferences? = null

    fun init(context: Context): AppDataHandler {
        preferences = context.getSharedPreferences("${context.getString(
            R.string.app_name
        )}_prefs", Context.MODE_PRIVATE)
        return this
    }

    fun setLastLaunchTime(time:Long){
        preferences?.putAny("last_launch_time",time)
    }

    fun getLastLaunchTime():Long? =
        preferences?.getLong("last_launch_time",0L)

}