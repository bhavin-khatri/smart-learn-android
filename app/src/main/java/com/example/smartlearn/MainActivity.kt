package com.example.smartlearn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility =View.SYSTEM_UI_FLAG_FULLSCREEN
        val Startbtn by lazy {
            findViewById<Button>(R.id.startQuizBtn)
        }
        val Entername by lazy {
            findViewById<TextInputEditText>(R.id.enternameTv)
        }
        Startbtn.setOnClickListener {
            if(Entername.text.toString().isEmpty())
            {
                Toast.makeText(this, "Name Cannot Be Empty", Toast.LENGTH_SHORT).show()
            }else if(Entername.text.toString().isDigitsOnly()){
                Toast.makeText(this, "Name Cannot Be Only Digit", Toast.LENGTH_SHORT).show()
            }
            else
            {
               val intent=Intent(this,HomeScreen::class.java)
                intent.putExtra(Constants.USER_NAME,Entername.text.toString())
                startActivity(intent)
                finish()
            }
        }
        }

        }




