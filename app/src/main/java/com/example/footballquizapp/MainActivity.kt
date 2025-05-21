package com.example.footballquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        val beginButton = findViewById<Button>(R.id.beginButton)
        val exitButton = findViewById<Button>(R.id.exitButton)


        beginButton.setOnClickListener {
            val intent = Intent(this, Quiz::class.java)
            startActivity(intent)

        }
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)

        }




    }
}