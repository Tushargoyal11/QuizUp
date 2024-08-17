package com.example.quizup

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.quizup.databinding.ActivityScoreAcitvityBinding

class ScoreAcitvity : AppCompatActivity() {

    private lateinit var binding: ActivityScoreAcitvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityScoreAcitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lottieAnimationView: LottieAnimationView = findViewById(R.id.lottieAnimationView)
        lottieAnimationView.playAnimation()
        binding.score.setText("Congrats you've Completed the Quiz.\n\nYour score is: ${intent.getIntExtra("Score",0)}")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}