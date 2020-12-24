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
    //val imageId = view.findViewById<ImageView>(R.id.imageId)

    fun bind(word:  Word, context : Context)
    {
        textId.text = word.eng

        //imageId.setImageResource(listItem.imageId)
        itemView.setOnClickListener(){

            val i = Intent(context, ExtendedItem::class.java ).apply{
                putExtra("text", word.rus.toString())
                //putExtra("image", listItem.imageId)
            }
            context.startActivity(i)
        }
    }
}