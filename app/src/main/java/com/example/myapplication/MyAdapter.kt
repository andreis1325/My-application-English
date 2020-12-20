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
import com.example.myapplication.db.Word

class MyAdapter (listArray : ArrayList<Word>, context : Context): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    var myListArray = listArray
    var myContext = context

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

/*
class MyAdapter (listArray : ArrayList<ItemClass>, context : Context): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    var myListArray = listArray
    var myContext = context

    class ViewHolder (view : View): RecyclerView.ViewHolder(view){
        val textId  = view.findViewById<TextView>(R.id.textId)
        //val imageId = view.findViewById<ImageView>(R.id.imageId)

        fun bind(listItem : ItemClass, context : Context)
        {
            textId.text = listItem.text
            //imageId.setImageResource(listItem.imageId)
            itemView.setOnClickListener(){
                Toast.makeText(context, "Pressed : ${textId.text}",Toast.LENGTH_SHORT).show()
                val i = Intent(context, ExtendedItem::class.java ).apply{
                    putExtra("text", textId.text.toString())
                    //putExtra("image", listItem.imageId)
                }
                context.startActivity(i)
            }
        }
    }

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
}
*/
