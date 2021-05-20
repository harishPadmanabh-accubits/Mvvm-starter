package com.accubits.mvvm_starter.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.accubits.mvvm_starter.data.models.UserModel

@Dao
interface UserDao {

    @Query("SELECT * from user_tb")
    fun getAllTracksList():LiveData<UserModel>
}