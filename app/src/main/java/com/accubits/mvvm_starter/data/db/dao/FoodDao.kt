package com.accubits.mvvm_starter.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.accubits.mvvm_starter.data.models.Category
import com.accubits.mvvm_starter.data.models.UserModel

@Dao
interface FoodDao {

    @Query("SELECT * from category_tb")
    fun getCategories(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(item : Category)




}