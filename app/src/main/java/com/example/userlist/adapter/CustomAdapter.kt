package com.example.userlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userlist.R
import com.example.userlist.interfaces.ItemClickListener
import com.example.userlist.model.User

class CustomAdapter(private val mList: List<User>?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    var itemClick:ItemClickListener?=null


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_user, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel =mList!!.get(position)// mList[position]

        holder.textName.text = itemsViewModel?.name
        holder.textEmail.text = "Email : "+itemsViewModel?.email
        holder.textGender.text = "Gender : "+itemsViewModel?.gender?.capitalize()
        holder.textStatus.text = "Status : "+itemsViewModel?.status?.capitalize()

        holder.itemView.setOnClickListener {
            itemClick?.onItemClickListener(itemsViewModel)
            //onItemClick?.invoke(photosListFiltered[adapterPosition])
        }


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList!!.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textName: TextView = itemView.findViewById(R.id.textViewName)
        val textEmail: TextView = itemView.findViewById(R.id.textViewEmail)
        val textGender: TextView = itemView.findViewById(R.id.textViewGender)
        val textStatus: TextView = itemView.findViewById(R.id.textViewStatus)
    }
}