 package com.example.myapplication.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

 class MyDbManager(context : Context) {
    val myDbHelper = MyDbHepler(context)
    var db : SQLiteDatabase? = null

    fun del(item :String){
        db = myDbHelper.readableDatabase
        db?.delete(MyDbNameClass.TABLE_NAME,item, null )
    }
    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title:String, content: String){
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
        }

        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }
    fun readDbData() : ArrayList<Word>{
        val dataList = ArrayList<Word>()

        val cursor = db?.query(MyDbNameClass.TABLE_NAME, null,  null, null,null, null, null)

        while(cursor?.moveToNext()!!){

            val eng = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
            val rus = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_CONTENT))


            dataList.add(Word(eng, rus))
        }
        cursor.close()
        Collections.reverse(dataList)
        return dataList
    }
    fun closeDb(){
        myDbHelper.close()
    }






}