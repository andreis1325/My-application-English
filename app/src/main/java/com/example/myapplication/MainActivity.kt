package com.example.myapplication

import android.app.Activity
import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.db.MyDbManager
import com.example.myapplication.db.Word
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {
    val myDbManager = MyDbManager(this)
    var randomItems = ArrayList<Word>()
    var itemPosition  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
       myDbManager.openDb()
        randomItems = myDbManager.readDbData()

        if(myDbManager.readDbData().size==0)
        {
            Toast.makeText(this, "List is empty", Toast.LENGTH_LONG).show()
            finish()
        }else{
            randomItems.shuffle()
            itemPosition = 0
            wordId.text = randomItems[itemPosition].eng
        }


    }


    fun toPrompt(view:View){
        Toast.makeText(this, randomItems[itemPosition].rus, Toast.LENGTH_LONG).show()
    }

    fun toNextWord(view: View)
    {
        if(wordId.getTag() == "false"){
            if (answer.text.toString().toLowerCase() == randomItems[itemPosition].rus){
                wordId.setBackgroundResource(R.drawable.radius_correct)
                wordId.tag="true"
            }
            else
                wordId.setBackgroundResource(R.drawable.radius_incorrect)
        }else{
            wordId.setBackgroundResource(R.drawable.radius)
            wordId.tag="false"
            itemPosition++
            if(itemPosition==randomItems.size){

                finish()
            }else{
                wordId.text = randomItems[itemPosition].eng
                answer.setText("")
            }
        }
    }
}

