package com.accubits.mvvm_starter.data.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class FoodLisResponse(
    @SerializedName("meals")
    val foods: List<Food>
) {


}