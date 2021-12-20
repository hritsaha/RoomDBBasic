package com.example.roomdb_test

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database : contactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        database= Room.databaseBuilder(applicationContext,contactDatabase :: class.java,"contactDB").build()

        database = contactDatabase.getDatabase(this)


        //global scope for using coroutines
        GlobalScope.launch {
            database.contactDAO().insertContact(contact(0,"Blake",77875,Date(),1))
        }
    }

    fun getData(view: View) {
        GlobalScope.launch {
            database.contactDAO().getContact().observe(this@MainActivity, Observer {
                Log.d("HRIT", it.toString())
            })
        }
    }
}