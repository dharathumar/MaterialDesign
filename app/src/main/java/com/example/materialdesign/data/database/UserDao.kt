package com.example.materialdesign.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.materialdesign.data.entity.Users

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(users: Users)

    @Query("Select * from user ORDER BY userid DESC")
    fun gelAllUsers(): LiveData<List<Users>>
}