package com.accubits.mvvm_starter.network

import android.content.Context
import com.accubits.mvvm_starter.network.exceptions.NoInternetException
import com.accubits.mvvm_starter.utils.CommonUtils
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.lang.Exception

class NetworkConnectionInterceptor (val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!CommonUtils.hasInternet(context)){
            throw NoInternetException()
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}
