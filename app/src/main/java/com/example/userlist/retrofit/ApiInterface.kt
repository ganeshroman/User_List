package com.example.weatherapp.retrofit

import com.example.userlist.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("users")
    fun getUser() : Call<List<User>>





}