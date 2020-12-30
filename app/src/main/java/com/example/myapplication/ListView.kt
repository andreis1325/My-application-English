package com.example.myapplication

import android.app.Service
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.db.MyDbManager
import com.example.myapplication.db.Word
import kotlinx.android.synthetic.main.activity_list_view.*


class ListView : AppCompatActivity() {

    var adapter : MyAdapter? = null
    val myDbManager = MyDbManager(this)
    val arrayList = ArrayList<Word>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        initOnCLickListeners()
        initAdapter()
    }

    private fun initAdapter(){
        adapter = MyAdapter(arrayList, this)
        vRvWords.adapter = adapter
    }

    private fun initOnCLickListeners(){
        vIvSearch.setOnClickListener(){
                onSearchClicked()
        }

        vFabAdd.setOnClickListener(){
            onAddItemClicked()
        }

    }

    override fun onResume(){
        super.onResume()
        myDbManager.openDb()
        vEtSearch.setText("")
        adapter?.updateAdapter(myDbManager.readDbData())

    }


    fun onAddItemClicked()
    {

        if(vEtWord1.text.toString() != "" && vEtWord2.text.toString() != ""){
            myDbManager.insertToDb(vEtWord1.text.toString().toLowerCase(), vEtWord2.text.toString().toLowerCase())
            adapter?.updateAdapter(myDbManager.readDbData())

            vEtWord1.setText("")
            vEtWord2.setText("")

            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
        }

    }

    fun onSearchClicked(){

        var view : View? = this.currentFocus
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if (vEtSearch?.visibility ==  View.GONE) {
            vEtSearch?.visibility = View.VISIBLE
            imm.showSoftInput(view, 0)
            vEtSearch?.requestFocus()
            vIvSearch?.setImageResource(R.drawable.cross)
        }
        else{
            vIvSearch?.setImageResource(R.drawable.search)
            vEtSearch?.setText("")
            vEtSearch?.visibility = View.GONE
            imm.hideSoftInputFromWindow(view?.windowToken,0)
        }

        vEtSearch?.addTextChangedListener( object: TextWatcher{

            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int){}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                var searchText = vEtSearch.text.toString().toLowerCase()
                var allItems = myDbManager.readDbData()
                var searchedItems = ArrayList<Word>()

                for(item in allItems){
                    if(searchText in item.eng && item.eng.indexOf(searchText)==0)
                        searchedItems.add(item)
                }
                adapter?.updateAdapter(searchedItems)
            }
        }
        )}
}












