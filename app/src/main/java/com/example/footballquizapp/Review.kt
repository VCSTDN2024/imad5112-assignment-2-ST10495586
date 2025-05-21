package com.example.footballquizapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Review : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val reviewTextView = findViewById<TextView>(R.id.reviewTextView)

        // Get the questions and answers from the intent
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")
        // Display the review in the TextView

        val reviewText = StringBuilder()
        if (questions != null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append(
                    "Answer: ${if (answers[i]) "True" else "False"}",

                    )


            }
            reviewTextView.text = reviewText.toString()
        } else {
            reviewTextView.text = "No review available."
        }

        //Allows user to go back to the first screen
        val restartButton = findViewById<Button>(R.id.restartButton)

        restartButton.setOnClickListener {
            finish()
        }
    }
}






