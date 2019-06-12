package com.example.iteradmin.firebaseapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var database:FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = FirebaseDatabase.getInstance()



        val name = findViewById<EditText>(R.id.name)
        val clg = findViewById<EditText>(R.id.clg)
        val city = findViewById<EditText>(R.id.city)
        val branch = findViewById<EditText>(R.id.branch)
        val txt=findViewById<TextView>(R.id.data)

        val s = findViewById<Button>(R.id.save)
        s.setOnClickListener{
            val name:String = name.text.toString()
            val clg:String = clg.text.toString()
            val city:String = city.text.toString()
            val branch:String = branch.text.toString()

            val ref:DatabaseReference = database.getReference("users").child("tanu")
            ref.child("name").setValue(name)
            ref.child("clg").setValue(clg)
            ref.child("city").setValue(city)
            ref.child("branch").setValue(branch)



        }
        val ref = database.getReference("message1")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {

                Toast.makeText(applicationContext,"not working",Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(p0: DataSnapshot) {

                val str=p0.getValue(String::class.java)
                txt.text=str
            }
        })




    }
}

