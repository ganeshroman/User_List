package com.example.userlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userlist.R
import com.example.userlist.model.User

class CustomAdapter(private val mList: List<User>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_user, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]


        holder.textName.text = itemsViewModel.name
        holder.textEmail.text = itemsViewModel.email
        holder.textGender.text = itemsViewModel.gender


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textName: TextView = itemView.findViewById(R.id.textViewName)
        val textEmail: TextView = itemView.findViewById(R.id.textViewEmail)
        val textGender: TextView = itemView.findViewById(R.id.textViewGender)
    }
}