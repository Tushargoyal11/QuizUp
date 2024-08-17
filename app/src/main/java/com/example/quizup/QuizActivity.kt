package com.example.quizup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizup.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private lateinit var list: ArrayList<QuestionModel>
    private var count:Int=0
    private var score:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list= ArrayList<QuestionModel>()
        list.add(QuestionModel("Who is the prime minister of India","Modi ji", "Rahul Gandhi", "Amit Shah", "None","Modi ji"))
        list.add(QuestionModel("Who is the prime minister of India","Rahul", "Modi", "Amit Shah", "None","Modi"))
        list.add(QuestionModel("Who is the prime minister of India","Modi ji", "Rahul Gandhi", "Amit Shah", "None","Modi ji"))
        list.add(QuestionModel("Who is the prime minister of India","Rahul", "Modi", "Amit Shah", "None","Modi"))

        binding.question.setText(list.get(0).question)
        binding.option1.setText(list.get(0).option1)
        binding.option2.setText(list.get(0).option2)
        binding.option3.setText(list.get(0).option3)
        binding.option4.setText(list.get(0).option4)

        binding.option1.setOnClickListener{
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener{
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener{
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener{
            nextData(binding.option4.text.toString())
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun nextData(i: String) {
        if(count<list.size){
            if (list.get(count).answer.equals(i)) {
                score++
            }
        }

        count++
        if(count>=list.size){
            val intent= Intent(this, ScoreAcitvity::class.java)
            intent.putExtra("Score",score)
            startActivity(intent)
            finish()
        }
        else {
            binding.question.setText(list.get(count).question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }
    }
}