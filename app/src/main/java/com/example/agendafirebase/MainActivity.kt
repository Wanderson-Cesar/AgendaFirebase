package com.example.agendafirebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var recyclerbtn : Button
    lateinit var userAddBtn : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerbtn = findViewById(R.id.recyclerviewbtn)
        userAddBtn = findViewById(R.id.addUserBtn)

        recyclerbtn.setOnClickListener {

            var i = Intent(this, ListarActivity::class.java)
            startActivity(i)
            finish()


        }
        userAddBtn.setOnClickListener {

            var i = Intent(this, AdicionarUserActivity::class.java)
            startActivity(i)
            finish()


        }
    }


}