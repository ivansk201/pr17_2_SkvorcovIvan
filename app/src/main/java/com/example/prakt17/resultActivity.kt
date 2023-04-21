package com.example.prakt17

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    private lateinit var resultTestView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result=intent.getFloatExtra("Результат",0f)
        val resulttextview=findViewById<TextView>(R.id.result_textview)
        resulttextview.text=getString(R.string.result_perimeter, result)


    }



}