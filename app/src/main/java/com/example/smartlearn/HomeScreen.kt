package com.example.smartlearn

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView

class HomeScreen() : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int=1
    private var mQuestionsList:ArrayList<Questions>?=null
    private var mSelectedOptionPosition:Int=0
    private lateinit var progressBar:ProgressBar
    private var mCorrectAnswer:Int=0
    private var mUserName: String? = null
    private lateinit var progresstxt:TextView
    private lateinit var questxt:TextView
    private lateinit var opt1:TextView
    private lateinit var opt2:TextView
    private lateinit var opt3:TextView
    private lateinit var opt4:TextView
    private lateinit var subBtn:Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList=Constants.getQuestions()

        progressBar=findViewById(R.id.progressBar)
        progresstxt=findViewById(R.id.progressText)
        questxt=findViewById(R.id.quesText)
        opt1=findViewById(R.id.option1TV)
        opt2=findViewById(R.id.option2TV)
        opt3=findViewById(R.id.option3TV)
        opt4=findViewById(R.id.option4TV)
        subBtn=findViewById(R.id.submitBtn)
        setQuestion()

        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        subBtn.setOnClickListener(this)

    }
    private fun setQuestion()
    {
        val questions=mQuestionsList!![mCurrentPosition-1]
        defaultOptionsView()
        if (mCurrentPosition === mQuestionsList!!.size){
            subBtn.text = "FINISH"
        }else{
            subBtn.text = "SUBMIT"
        }
        progressBar.progress=mCurrentPosition
        progresstxt.text="$mCurrentPosition"+ "/"+progressBar.max
        questxt.text=questions!!.question
        opt1.text=questions.optionOne
        opt2.text=questions.optionTwo
        opt3.text=questions.optionThree
        opt4.text=questions.optionFour
    }
    private fun defaultOptionsView(){
        val  options = ArrayList<TextView>()
        options.add(0, opt1)
        options.add(1, opt2)
        options.add(2, opt3)
        options.add(3, opt4)

        for (option in options){
            option.setTextColor(Color.parseColor("black"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.border_bg
            )
        }
        
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option1TV ->{
                selectoptionview(opt1, 1)
            }
            R.id.option2TV ->{
                selectoptionview(opt2, 2)
            }
            R.id.option3TV ->{
                selectoptionview(opt3, 3)
            }
            R.id.option4TV ->{
                selectoptionview(opt4, 4)
            }
            R.id.submitBtn->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTION,mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val questions = mQuestionsList?.get(mCurrentPosition -1)
                    if (questions!!.correctAns != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(questions.correctAns, R.drawable.correct_border_bg)
                    if (mCurrentPosition === mQuestionsList!!.size){
                        subBtn.text = "FINISH"
                    }else{
                        subBtn.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }


    }
    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1->{
                opt1.background = ContextCompat.getDrawable(this , drawableView)
            }
            2->{
                opt2.background = ContextCompat.getDrawable(this , drawableView)
            }
            3->{
                opt3.background = ContextCompat.getDrawable(this , drawableView)
            }
            4->{
                opt4.background = ContextCompat.getDrawable(this , drawableView)
            }
        }
    }
    private fun selectoptionview(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#FF8F07"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_border_bg)
    }
}