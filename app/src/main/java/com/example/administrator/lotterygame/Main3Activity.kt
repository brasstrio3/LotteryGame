package com.example.administrator.lotterygame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        displayResults()
        setOnClickListenerForClose()
        setOnClickListenerForPlayAgain()
    }

    private fun displayResults() {
        var counter = (getIntent().getExtras().getInt("Coins"))

        txtThanks.text = "Thanks for playing!!! You have ended the game with " + counter + " coins!" +
                " Would you like to play again?"
    }

    private fun setOnClickListenerForClose() {
        btnClose.setOnClickListener {
            finishAffinity()
        }
    }

    private fun setOnClickListenerForPlayAgain() {
        btnStartNewGame.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
