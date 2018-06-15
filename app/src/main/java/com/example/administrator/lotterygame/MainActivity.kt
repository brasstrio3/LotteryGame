package com.example.administrator.lotterygame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import com.example.administrator.lotterygame.R.id.btnSubmit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListenerForButton()
    }

    private fun setOnClickListenerForButton() {
        btnSubmit.setOnClickListener {
            if (txtUserCoins.text.toString().equals("")) {
                toast("Please enter a starting amount")
            }
            else {
                val intent = Intent("com.example.administrator.lotterygame.Main2Activity")
                intent.putExtra("Coins", txtUserCoins.text.toString().toInt())
                startActivity(intent)
            }
        }
    }
}