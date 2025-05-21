package com.example.footballquizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Quiz : AppCompatActivity() {


    private lateinit var questionsTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var feedbackTextView: TextView


    companion object {
        val questions = arrayOf(
            "Cristiano Ronaldo was born in 1985",
            "F.C. Barcelona has won more Champions Leagues than Real Madrid",
            "Eden Hazard is still actively playing football",
            "Lionel Messi is the current top scorer of all time",
            "Luca Modric has more Champions Leagues than the club Arsenal"
        )

        val answers = booleanArrayOf(true, false, false, false, true)
    }

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        questionsTextView = findViewById(R.id.questionsTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)
        feedbackTextView = findViewById(R.id.feedbackTextView)


        //Display the first question
        displayQuestion()

        // Initializing the answer button
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }


        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
                feedbackTextView.text = ""
                trueButton.isEnabled = true
                falseButton.isEnabled = true
            } else {
                val intent = Intent(this, Score::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }


        }

    }

    private fun displayQuestion() {
        questionsTextView.text = questions[currentQuestionIndex]

    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]

        if (userAnswer == correctAnswer) {
            score++
            feedbackTextView.text = "Correct!"
            feedbackTextView.setTextColor(Color.GREEN)
        } else {
            feedbackTextView.text = "Incorrect!"
            feedbackTextView.setTextColor(Color.RED)


        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true


    }
}



