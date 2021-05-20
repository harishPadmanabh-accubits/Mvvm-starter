package com.accubits.mvvm_starter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "category_tb")
data class Category(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("idCategory")
    val idCategory: String,

    @ColumnInfo(name = "name")
    @SerializedName("strCategory")
    val strCategory: String,

    @ColumnInfo(name = "desc")
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String,

    @ColumnInfo(name = "imageUrl")
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String
)