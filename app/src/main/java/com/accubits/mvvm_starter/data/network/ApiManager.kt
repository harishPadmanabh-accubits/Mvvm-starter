package com.accubits.mvvm_starter.data.network

import android.content.Context
import com.accubits.mvvm_starter.BuildConfig
import com.accubits.mvvm_starter.constants.BASE_URL
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//pass either Application or context scopes in constructor . Use it from Repositories
class ApiManger(appContext: Context) {
    var api : ApiServices ?= null
    init{
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(NetworkConnectionInterceptor(appContext))
            .addInterceptor(loggingInterceptor)
            .build()

        val restAdapter = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
        api = restAdapter.create(ApiServices::class.java)



    }


}



//https://medium.com/programming-lite/retrofit-2-handling-network-error-defc7d373ad1