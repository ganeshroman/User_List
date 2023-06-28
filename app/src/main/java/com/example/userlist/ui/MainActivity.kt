package com.example.userlist.ui


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userlist.adapter.CustomAdapter
import com.example.userlist.databinding.ActivityMainBinding
import com.example.userlist.interfaces.ItemClickListener
import com.example.userlist.model.User
import com.example.userlist.ui.dialog.DetailsDialogFragment
import com.example.userlist.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var context: Context
    lateinit var adapter:CustomAdapter
    lateinit var mainActivityViewModel: MainViewModel


    companion object {
        val requestcode:Int=1234
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this@MainActivity
        mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnClick.setOnClickListener {

            var strFilter:String=binding.edtName.text.toString();
            var strFilterMale:String=binding.edtGender.text.toString();
            var filteredList:List<User>? = mainActivityViewModel.servicesLiveData?.value?.filter { it.name.contains(""+strFilter) }

            getUpdateOnList(filteredList);
            adapter.notifyDataSetChanged()
        }


        binding.btnClear.setOnClickListener{
            getUpdateOnList(mainActivityViewModel.servicesLiveData?.value);
            adapter.notifyDataSetChanged()
        }


        getUpdateUser()
    }


    @SuppressLint("SuspiciousIndentation")
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



    fun getUpdateOnList( listElements: List<User>? ){
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        adapter = CustomAdapter(listElements)
        adapter.itemClick= object : ItemClickListener {
            override fun onItemClickListener(item: User) {


                DetailsDialogFragment.newInstance(item.name, item.email,item.gender,item.status)
                    .show(supportFragmentManager, DetailsDialogFragment.TAG)
            }
        }


        binding.recyclerview.adapter = adapter
    }


}