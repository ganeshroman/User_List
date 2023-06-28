package com.example.userlist.ui


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userlist.R
import com.example.userlist.adapter.CustomAdapter
import com.example.userlist.databinding.ActivityMainBinding
import com.example.userlist.model.User
import com.example.userlist.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var context: Context


    companion object {
        val requestcode:Int=1234
    }

    lateinit var mainActivityViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnClick.setOnClickListener {
            getUpdateUser()
        }

    }


    fun getUpdateUser(){
        binding.wp7progressBar.visibility = View.VISIBLE


            mainActivityViewModel.getUser()!!
                .observe(this, Observer { serviceSetterGetter ->

                    binding.wp7progressBar.visibility = View.GONE
                    val msg = serviceSetterGetter.toString()
                    //binding.txtDebug.setText(""+msg)

                    getObserverList()
                })
    }


    fun getObserverList(){
        mainActivityViewModel.servicesLiveData!!
            .observe(this, Observer { serviceSetterGetter ->

                binding.wp7progressBar.visibility = View.GONE

                getUpdateOnList(serviceSetterGetter)

            })
    }



    fun getUpdateOnList( listElements: List<User> ){
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(listElements)
        binding.recyclerview.adapter = adapter
    }


}