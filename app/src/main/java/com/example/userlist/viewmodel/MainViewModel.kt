package com.example.userlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userlist.model.User
import com.example.userlist.repository.UserRepository

class MainViewModel : ViewModel() {

    var servicesLiveData: MutableLiveData<List<User>>? = null

    fun getUser() : LiveData<List<User>>? {
        servicesLiveData = UserRepository.getUserApiCall()
        return servicesLiveData
    }

}