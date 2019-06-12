package com.example.iteradmin.firebaseapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase

class frag_one():AppCompatActivity()
{
    private lateinit var database:FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val e=findViewById<EditText>(R.id.message)
        val s=findViewById<Button>(R.id.save)

        s.setOnClickListener {

            val data:String=e.text.toString()
            val ref: DatabaseReference =database.getReference("message1")
            ref.setValue(data)

        }
    }

}