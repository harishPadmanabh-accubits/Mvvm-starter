package com.accubits.mvvm_starter.data.network

import com.accubits.mvvm_starter.data.models.Category
import com.accubits.mvvm_starter.data.models.CategoryResponse
import com.accubits.mvvm_starter.data.models.FoodLisResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("categories.php")
    fun getCategories(): Call<CategoryResponse>

    @GET("filter.php")
    fun getFoodsByCategory(@Query("c") category: String) : Call<FoodLisResponse>
}