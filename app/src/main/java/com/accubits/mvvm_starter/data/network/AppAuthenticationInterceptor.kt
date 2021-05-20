package com.accubits.mvvm_starter.data.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
/*
* Add custom auth headers  in the builder
* */
class AppAuthenticationInterceptor (var appContext: Context) : Interceptor {


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val builder = original.newBuilder()


        val request = builder.build()


        return chain.proceed(request)


    }
}
