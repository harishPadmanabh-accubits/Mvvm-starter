package com.accubits.mvvm_starter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_tb")
data class UserModel(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id:Int,

        @ColumnInfo(name = "name")
        val name : String,

        @ColumnInfo(name = "email")
        val email : String,

        @ColumnInfo(name = "phone")
        val phone : String
) {
}