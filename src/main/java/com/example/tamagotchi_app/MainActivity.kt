package com.example.tamagotchi_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)

        // code for linking the two activities
        btnStart.setOnClickListener{
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}