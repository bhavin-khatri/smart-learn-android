package com.example.smartlearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var userName:TextView
    private lateinit var score:TextView
    private lateinit var finish:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        userName=findViewById(R.id.userNameTV)
        score=findViewById(R.id.scoreTv)
        finish=findViewById(R.id.finishBtn)
        val username = intent.getStringExtra(Constants.USER_NAME)
        userName.text=username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        score.text="Your Score is $correctAnswer out of $totalQuestions"
        finish.setOnClickListener(View.OnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        })
    }
}