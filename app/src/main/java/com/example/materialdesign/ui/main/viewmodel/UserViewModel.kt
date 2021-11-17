package com.example.materialdesign.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.materialdesign.data.database.UserDatabase
import com.example.materialdesign.data.entity.Users
import com.example.materialdesign.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(app: Application) : AndroidViewModel(app) {


    lateinit var allUser: LiveData<List<Users>>
    lateinit var repository: UserRepository

    init {
        val userDao = UserDatabase.getInstance(getApplication())?.userDao()
        repository = UserRepository(userDao)
        allUser = repository.allUsers

    }
    fun insertUserInfo(users: Users)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(users)
    }
}