package com.example.userlist.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.userlist.model.User
import com.example.weatherapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object UserRepository {

    val userSetterGetter = MutableLiveData<List<User>>()

    fun getUserApiCall(): MutableLiveData<List<User>> {

        val call = RetrofitClient.apiInterface.getUser()

        call.enqueue(object: Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()

                userSetterGetter.value=response.body()

                //val msg = data!!.message
            }
        })

        return userSetterGetter
    }




}