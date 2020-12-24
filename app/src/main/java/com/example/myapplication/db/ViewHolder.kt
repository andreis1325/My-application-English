package com.example.myapplication.db

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ExtendedItem
import com.example.myapplication.R

class ViewHolder (view : View): RecyclerView.ViewHolder(view){
    val textId  = view.findViewById<TextView>(R.id.textId)


    fun bind(word:  Word, context : Context)
    {
        textId.text = word.eng

        itemView.setOnClickListener(){

            val i = Intent(context, ExtendedItem::class.java ).apply{
                putExtra("text", word.rus.toString())
            }
            context.startActivity(i)
        }
    }
}