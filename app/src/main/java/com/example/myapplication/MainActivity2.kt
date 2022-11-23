package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(),View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetbutton: Button
    private lateinit var resultname1: TextView
    private lateinit var resultname2: TextView
    private var game=0
    private var scoreF=0
    private var scoreS=0

    private lateinit var score1:TextView
    private lateinit var score2:TextView

    private var activePlayer = 1
    private var fPlayer = ArrayList<Int>()
    private var sPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
        score1=findViewById(R.id.score1)
        score2=findViewById(R.id.score2)

        resetbutton.setOnClickListener{
            reset()
        }
    }
    private fun reset() {
        button1.text=""
        button2.text=""
        button3.text=""
        button4.text=""
        button5.text=""
        button6.text=""
        button7.text=""
        button8.text=""
        button9.text=""

        button1.setBackgroundColor(Color.WHITE)
        button2.setBackgroundColor(Color.WHITE)
        button3.setBackgroundColor(Color.WHITE)
        button4.setBackgroundColor(Color.WHITE)
        button5.setBackgroundColor(Color.WHITE)
        button6.setBackgroundColor(Color.WHITE)
        button7.setBackgroundColor(Color.WHITE)
        button8.setBackgroundColor(Color.WHITE)
        button9.setBackgroundColor(Color.WHITE)

        activePlayer=1

        game=0

        button1.isEnabled=true
        button2.isEnabled=true
        button3.isEnabled=true
        button4.isEnabled=true
        button5.isEnabled=true
        button6.isEnabled=true
        button7.isEnabled=true
        button8.isEnabled=true
        button9.isEnabled=true

        fPlayer.clear()
        sPlayer.clear()

        if(scoreF==3 || scoreS==3){
            activePlayer=3
        }
    }

    private fun init() {

        val name1=intent.extras?.getString("firsPlayer")
        val name2=intent.extras?.getString("secondPlayer")

        resultname1=findViewById(R.id.player1)
        resultname2=findViewById(R.id.player2)

        resultname1.text=name1
        resultname2.text=name2


        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetbutton = findViewById(R.id.resetbutton)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
    }
    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
        }
    }
    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.GRAY)
            activePlayer = 2
            fPlayer.add(buttonNumber)

        } else if (activePlayer == 2) {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.BLUE)
            activePlayer = 1
            sPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        if(game==0) {
            check()
        }
        clickedView.isEnabled=false
        if (game==1){
            activePlayer==3
        }

    }
    private fun check() {
        var wPlayer = 0
        if (fPlayer.contains(1) && fPlayer.contains(2) && fPlayer.contains(3)) {
            wPlayer = 1
        }
        if (sPlayer.contains(1) && sPlayer.contains(2) && sPlayer.contains(3)) {
            wPlayer = 2
        }
        if (sPlayer.contains(4) && sPlayer.contains(5) && sPlayer.contains(6)) {
            wPlayer = 2
        }
        if (fPlayer.contains(4) && fPlayer.contains(5) && fPlayer.contains(6)) {
            wPlayer = 1
        }
        if (fPlayer.contains(7) && fPlayer.contains(8) && fPlayer.contains(9)) {
            wPlayer = 1
        }
        if (sPlayer.contains(7) && sPlayer.contains(8) && sPlayer.contains(9)) {
            wPlayer = 2
        }
        if (sPlayer.contains(1) && sPlayer.contains(4) && sPlayer.contains(7)) {
            wPlayer = 2
        }
        if (fPlayer.contains(1) && fPlayer.contains(4) && fPlayer.contains(7)) {
            wPlayer = 1
        }
        if (fPlayer.contains(2) && fPlayer.contains(5) && fPlayer.contains(8)) {
            wPlayer = 1
        }
        if (sPlayer.contains(2) && sPlayer.contains(5) && sPlayer.contains(8)) {
            wPlayer = 2
        }
        if (sPlayer.contains(3) && sPlayer.contains(6) && sPlayer.contains(9)) {
            wPlayer = 2
        }
        if (fPlayer.contains(3) && fPlayer.contains(6) && fPlayer.contains(9)) {
            wPlayer = 1
        }
        if (fPlayer.contains(1) && fPlayer.contains(5) && fPlayer.contains(9)) {
            wPlayer = 1
        }
        if (sPlayer.contains(1) && sPlayer.contains(5) && sPlayer.contains(9)) {
            wPlayer = 2
        }
        if (sPlayer.contains(3) && sPlayer.contains(5) && sPlayer.contains(7)) {
            wPlayer = 2
        }
        if (fPlayer.contains(3) && fPlayer.contains(5) && fPlayer.contains(7)) {
            wPlayer = 1
        }
        if(wPlayer==1){
            game=1
            scoreF+=1
            score1.text=scoreF.toString()
            if(scoreF==3){
                Toast.makeText(this, "შეხვედრა მოიგო პირველმა", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(this, "თამაში მოიგო პირველმა", Toast.LENGTH_SHORT).show()
        }
        if(wPlayer==2){
            game=1
            scoreS+=1
            score2.text=scoreS.toString()
            if(scoreS==3){
                Toast.makeText(this, "შეხვედრა მოიგო მეორემ", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(this, "თამაში მოიგო მეორემ", Toast.LENGTH_SHORT).show()
        }
        if (fPlayer.size + sPlayer.size == 9 && wPlayer == 0) {
            Toast.makeText(applicationContext, " გაიმარჯვა მეგობრობამ ", Toast.LENGTH_LONG).show()
        }
    }
}