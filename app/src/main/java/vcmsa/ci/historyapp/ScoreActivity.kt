package vcmsa.ci.historyapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)

        val scoreText: TextView = findViewById(R.id.scoreText)
        val feedbackText: TextView = findViewById(R.id.feedbackText)
        val exitButton: Button = findViewById(R.id.exitButton)

        scoreText.text = "Score: $score / 5"
        feedbackText.text = if (score >= 3) "Great job!" else "Keep practising!"


        exitButton.setOnClickListener {
            finishAffinity() // Closes all activities and exits
        }
    }
}