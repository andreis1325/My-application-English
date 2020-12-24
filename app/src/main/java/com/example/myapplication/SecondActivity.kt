package com.example.myapplication

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    var test: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()
        //val imm: InputMethodManager = this.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
        //imm.showSoftInput(test, 0)

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