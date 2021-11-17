package com.example.materialdesign.data.repository

import androidx.lifecycle.LiveData
import com.example.materialdesign.data.database.UserDao
import com.example.materialdesign.data.entity.Users

class UserRepository (private val dao: UserDao) {

    val users = dao.gelAllUsers()
    val allUsers: LiveData<List<Users>> = dao.gelAllUsers()

    suspend fun insert(user: Users) {
        dao.insertUser(user)
    }


}