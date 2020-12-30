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
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initOnClickListeners()
    }

    private fun initOnClickListeners(){
        goToTestingButtonId.setOnClickListener(){
            onToTestingButtonClicked()
        }
        goToWordListButtonId.setOnClickListener(){
            onToListViewButtonClicked()
        }
    }

    fun onToTestingButtonClicked()
    {
       val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onToListViewButtonClicked()
    {
        val intent2 = Intent(this, ListView::class.java)
        startActivity(intent2)
    }
}