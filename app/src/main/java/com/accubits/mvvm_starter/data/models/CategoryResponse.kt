package com.accubits.mvvm_starter.data.models


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("categories")
    val categories: List<Category>
) {

}