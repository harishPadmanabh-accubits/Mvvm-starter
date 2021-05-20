package com.accubits.mvvm_starter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "food_tb")
data class Food(

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("idMeal")
    val idMeal: String,

    @ColumnInfo(name = "name")
    @SerializedName("strMeal")
    val strMeal: String,

    @ColumnInfo(name = "desc")
    @SerializedName("strMealThumb")
    val strMealThumb: String
)