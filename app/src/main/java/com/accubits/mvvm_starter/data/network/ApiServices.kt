package com.accubits.mvvm_starter.data.network

import com.accubits.mvvm_starter.data.models.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("categories.php")
    fun getCategories(): Call<CategoryResponse>
}