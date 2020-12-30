package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.db.MyDbManager
import kotlinx.android.synthetic.main.activity_extended_item.*

class ExtendedItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extended_item)

        initOnClickedListeners()
        showWords()
    }

    private fun showWords(){
        var str = intent.getCharSequenceExtra("text").toString()
        var translate= intent.getCharSequenceExtra("translation").toString()
        text2Id.text = translate + " - " + str
    }

    private fun initOnClickedListeners(){
        deleteItemId.setOnClickListener(){
            onDeleteItemClicked()
        }

    }

    fun onDeleteItemClicked() {
        val myDbManager = MyDbManager(this)
        var str =intent.getCharSequenceExtra("text").toString()
        myDbManager.del("content = "+ "'$str'")
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        finish()
    }
}