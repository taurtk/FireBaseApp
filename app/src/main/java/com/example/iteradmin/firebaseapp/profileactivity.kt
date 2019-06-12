package com.example.iteradmin.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class profileactivity : AppCompatActivity() {


    private lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profileactivity)
        mAuth=FirebaseAuth.getInstance()
        val text=findViewById<TextView>(R.id.text)
        val signUp=findViewById<Button>(R.id.button)
        val edit=findViewById<Button>(R.id.button1)
        val user:FirebaseUser?=mAuth.currentUser
        if(user!=null)
        {
            text.text=user.uid

        }
        signUp.setOnClickListener {
            mAuth.signOut()
            finish()
        }
        edit.setOnClickListener {

            startActivity(Intent(this,editprofile::class.java))
        }
    }
}
