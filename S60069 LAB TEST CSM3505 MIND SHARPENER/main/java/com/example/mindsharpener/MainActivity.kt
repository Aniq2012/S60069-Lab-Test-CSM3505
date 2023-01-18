//   Name :Aniq Hazim Bin Badrolhiszaman
//   Matric Number : S60069

package com.example.mindsharpener

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var score = 0
    lateinit var questionTextView: TextView
    lateinit var option1RadioButton: RadioButton
    lateinit var option2RadioButton: RadioButton
    lateinit var option3RadioButton: RadioButton
    lateinit var option4RadioButton: RadioButton
    lateinit var submitButton: Button
    lateinit var scoreTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.question_text_view)
        option1RadioButton = findViewById(R.id.option1_radio_button)
        option2RadioButton = findViewById(R.id.option2_radio_button)
        option3RadioButton = findViewById(R.id.option3_radio_button)
        option4RadioButton = findViewById(R.id.option4_radio_button)
        submitButton = findViewById(R.id.submit_button)
        scoreTextView = findViewById(R.id.score_text_view)

        loadQuestion()
    }

    private fun loadQuestion() {
        val question = getQuestion()
        questionTextView.text = question.question
        option1RadioButton.text = question.option1
        option2RadioButton.text = question.option2
        option3RadioButton.text = question.option3
        option4RadioButton.text = question.option4

        option1RadioButton.setOnClickListener { checkAnswer(question.option1) }
        option2RadioButton.setOnClickListener { checkAnswer(question.option2) }
        option3RadioButton.setOnClickListener { checkAnswer(question.option3) }
        option4RadioButton.setOnClickListener { checkAnswer(question.option4) }
    }

    private fun checkAnswer(answer: String) {
        if (answer == getQuestion().answer) {
            score++
            scoreTextView.text = "Point: $score"
        }
    }

    private fun getQuestion(): Question {
        // List of array question and optional answer
        return Question("2 + 2 = ?", "3", "4", "5", "6", "4")
    }
}

data class Question(
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val answer: String
)
