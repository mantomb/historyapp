package vcmsa.ci.historyapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "The Berlin Wall fell in 1989.",
        "Cleopatra was a pharaoh of ancient Greece.",
        "The American Civil War ended in 1865.",
        "Gandhi led a violent revolt against the British.",
        "The Titanic sank in 1912."
    )

    private val answers = booleanArrayOf(true, false, true, false, true)

    private val imageIds = intArrayOf(
        R.drawable.q1, R.drawable.q2, R.drawable.q3, R.drawable.q4, R.drawable.q5
    )

    private var currentIndex = 0
    private var score = 0

    private lateinit var questionText: TextView
    private lateinit var questionImage: ImageView
    private lateinit var feedbackText: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.questionText)
        questionImage = findViewById(R.id.questionImage)
        feedbackText = findViewById(R.id.feedbackText)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)

        loadQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = questions[currentIndex]
        questionImage.setImageResource(imageIds[currentIndex])
        feedbackText.text = ""
        trueButton.isEnabled = true
        falseButton.isEnabled = true
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            feedbackText.text = "Correct!"
            score++
        } else {
            feedbackText.text = "Incorrect."
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
    }
}