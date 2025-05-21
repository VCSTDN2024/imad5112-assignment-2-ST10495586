package com.example.footballquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val score = intent.getIntExtra("score", 0)
        scoreTextView.text = "Your Score: $score"

        if (score >= 3) {
            feedbackTextView.text = "Congratulations! You passed the quiz."
        } else {
            feedbackTextView.text = "Sorry, you failed the quiz."

        }

        reviewButton.setOnClickListener {
            val intent = Intent(this, Review::class.java)
            intent.putExtra("questions", Quiz.questions)
            intent.putExtra("answers", Quiz.answers)
            startActivity(intent)
            finish()
        }
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)


        }






    }
}