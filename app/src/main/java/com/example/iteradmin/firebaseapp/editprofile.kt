package com.example.iteradmin.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.widget.Button

class editprofile : FragmentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val but=findViewById<Button>(R.id.button)
        but.setOnClickListener{
            val fragmentManager =supportFragmentManager
            val fragmentTransition=fragmentManager.beginTransaction()

            val first=frag_one()
              //  fragmentTransition.replace(R.id.frag_one,first)
                fragmentTransition.addToBackStack(null)
                fragmentTransition.commit()}


            /*fragmentTransition.add(R.id.frag_one,second)
            fragmentTransition.commit()*/
        }
    }

