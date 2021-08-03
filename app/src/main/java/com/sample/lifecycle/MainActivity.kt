package com.sample.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sample.lifecycle.models.QuestionModel

class MainActivity : AppCompatActivity() {
    private lateinit var questionModel:QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //questionModel = ViewModelProvider(this).get(QuestionModel::class.java)
        questionModel = QuestionModel.getInstance()
        val btn: Button = findViewById(R.id.btnNext)
        btn.setOnClickListener(){
            var intent:Intent = Intent(this, SecondActivity::class.java)
            questionModel.name = findViewById<TextView>(R.id.tfName).text.toString()
            startActivity(intent)
        }
    }
}