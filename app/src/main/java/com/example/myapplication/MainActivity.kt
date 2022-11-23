package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        var Pname1 = findViewById<EditText>(R.id.et1)
        var Pname2 = findViewById<EditText>(R.id.et2)

        button.setOnClickListener {

            var resultName1 = Pname1.text.toString()
            var resultName2 = Pname2.text.toString()

            if (resultName1 == "" || resultName2 == "") {
                Toast.makeText(this, "გთხოვთ შეიყვანოთ მოთამაშეების სახელები ", Toast.LENGTH_SHORT).show()
            } else {
                val change = Intent(this, MainActivity2::class.java).also {
                    intent.putExtra("firstPlayer", resultName1)
                    intent.putExtra("secondPlayer", resultName2)
                }
                startActivity(change)
            }
        }


    }
}