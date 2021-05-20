package com.accubits.mvvm_starter.data.repositories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.accubits.mvvm_starter.data.db.AppDatabase


class AuthRepository(val context: Context) {

    var authStatus = MutableLiveData<AuthKeys>()
    val database = AppDatabase.getDatabase(context)



}

enum class AuthKeys{
    SIGNIN_START,
    SIGNIN_SUCCESS,
    SIGNIN_FAILED,
    SIGNUP_START,
    SIGNUP_SUCCESS,
    SIGNUP_FAILED,
}