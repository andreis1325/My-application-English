package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.db.ViewHolder
import com.example.myapplication.db.Word

class MyAdapter (listArray : ArrayList<Word>, context : Context): RecyclerView.Adapter<ViewHolder>(){
    var myListArray = listArray
    var myContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(myContext)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myListArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = myListArray.get(position)
        holder.bind(listItem, myContext)
    }
    fun updateAdapter(listItems: ArrayList<Word>){
        myListArray.clear()
        myListArray.addAll(listItems)
        notifyDataSetChanged()
    }
}


