package com.sample.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sample.lifecycle.models.QuestionModel

class SecondActivity : AppCompatActivity() {
    private lateinit var questionModel:QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.i("LifeCycle","onCreate")

        val btn : Button = findViewById(R.id.btnAdd)
        val tv : TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)

        //questionModel = ViewModelProvider(this).get(QuestionModel::class.java)
        questionModel = QuestionModel.getInstance()
        tv.text = questionModel.getQuestion()
        tvName.text = questionModel.name
        //if(savedInstanceState != null)
        //    tv.text = savedInstanceState?.getString("question")
        btn.setOnClickListener(){
            tv.text = questionModel.generateQuestion()
        }
    }

    override fun onStart(){
        super.onStart()
        Log.i("LifeCycle", "onStart")
    }
    override fun onResume(){
        super.onResume()
        Log.i("LifeCycle", "onResume")
    }
    override fun onPause(){
        super.onPause()
        Log.i("LifeCycle", "onPause")
    }
    override fun onStop(){
        super.onStop()
        Log.i("LifeCycle", "onStop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i("LifeCycle", "onDestroy")
    }
/*
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tvQ:TextView = findViewById(R.id.tvQuestion)
        outState.putString("question",tvQ.text.toString())
    }
*/
}