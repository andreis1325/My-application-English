package com.example.myapplication.db

import android.content.Context
import android.content.Intent
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ExtendedItem
import com.example.myapplication.R
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewHolder (view : View): RecyclerView.ViewHolder(view){


    fun bind(word:  Word, context : Context)
    {
        itemView.vTvItemWord.text = word.eng

        itemView.setOnClickListener(){

            val i = Intent(context, ExtendedItem::class.java ).apply{
                putExtra("text", word.rus.toString())
                putExtra("translation", word.eng.toString())
            }
            context.startActivity(i)
        }
    }
}