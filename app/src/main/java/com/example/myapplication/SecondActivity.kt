package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun toSecondActivity(view: View)
    {
       val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun toListView(view:View)
    {
        val intent2 = Intent(this, ListView::class.java)
        startActivity(intent2)
    }
}