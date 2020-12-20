package com.example.myapplication

import android.app.Application
import android.content.Intent
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.db.MyDbManager
import com.example.myapplication.db.Word
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.item_layout.*
import java.util.*
import kotlin.collections.ArrayList


class ListView : AppCompatActivity() {
    var adapter : MyAdapter? = null
    val myDbManager = MyDbManager(this)

    val arrayList = ArrayList<Word>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        viewId.hasFixedSize()
        viewId.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(arrayList, this)
        viewId.adapter = adapter

    }

    override fun onResume(){
        super.onResume()
        myDbManager.openDb()
        editTextId.setText("")
        adapter?.updateAdapter(myDbManager.readDbData())
        //arrayItem = myDbManager.readDbData()
        //adapter = MyAdapter(arrayItem, this)
        //viewId.adapter = adapter
    }


    fun addItem(view: View)
    {
        var word1 = word1Id.text.toString()
        var word2 = word2Id.text.toString()

        if(word1 != "" && word2 != ""){
            myDbManager.insertToDb(word1.toLowerCase(), word2.toLowerCase())
            adapter?.updateAdapter(myDbManager.readDbData())
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
            word1Id.setText("")
            word2Id.setText("")

        }

    }

    fun searchId(view:View){

            var searchText = editTextId.text
            var allItems = myDbManager.readDbData()
            var searchedItems = ArrayList<Word>()

            for(item in allItems){
                if(searchText in item.eng && item.eng.indexOf(searchText.toString())==0)
                    searchedItems.add(item)
            }
            adapter?.updateAdapter(searchedItems)
        }

}








/*
class ListView : AppCompatActivity() {
    var adapter : MyAdapter? = null
    var arrayItem = ArrayList<ItemClass>()

    val myDbManager = MyDbManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)


        arrayItem.add(ItemClass(R.drawable.blood_cells,"blood cells"))
        arrayItem.add(ItemClass(R.drawable.planet_earth,"planet earth"))
        arrayItem.add(ItemClass(R.drawable.orange,"orange"))
        arrayItem.add(ItemClass(R.drawable.power,"power"))
        arrayItem.add(ItemClass(R.drawable.power2,"power 2"))

        viewId.hasFixedSize()
        viewId.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(arrayItem, this)
        viewId.adapter = adapter
    }
    override fun onResume(){
        super.onResume()
        myDbManager.openDb()
        var dbTitle = myDbManager.readDbData()

        for (item in  dbTitle){
            infoId.append(item)
            infoId.append("\n")
        }

    }
    fun addItem(view: View)
    {

            arrayItem.add(ItemClass(R.drawable.power2,titleId.text.toString()))
            adapter?.notifyDataSetChanged()
    }

    fun deleteItem(view:View)
    {
        arrayItem.removeAt(0)
        adapter?.notifyDataSetChanged()
    }

    fun save(view:View){

        infoId.text=""

        myDbManager.insertToDb(titleId.text.toString(), contentId.text.toString())

        var dbTitle = myDbManager.readDbData()

            for (item in  dbTitle){
                infoId.append(item)
                infoId.append("\n")
            }
    }
}


 */







