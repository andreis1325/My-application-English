package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.db.MyDbManager
import kotlinx.android.synthetic.main.activity_extended_item.*

class ExtendedItem : AppCompatActivity() {
    val myDbManager = MyDbManager(this)
    var str = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extended_item)


        text2Id.text = intent.getCharSequenceExtra("text")
        str = intent.getCharSequenceExtra("text").toString()
    }

    fun delete(view: View) {

        //myDbManager.openDb()
        var num = myDbManager.del("content = "+ "'$str'")
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        finish()
    }

}