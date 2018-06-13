package com.example.administrator.lotterygame

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spin()

    }

    //Generates a random number between 1 and 4. Will be used to display pictures later
    private fun generateRandomNumber(): Int {
        val number = Random()
        val min = 1
        val max = 4
        val num = number.nextInt(max + 1 - min) + min
        return num
    }

    private fun spin() {
        var counter = 0

        btnSpin.setOnClickListener() {
            when (generateRandomNumber()) {
                1 -> pic1.setImageResource(R.drawable.bell)
                2 -> pic1.setImageResource(R.drawable.cherries)
                3 -> pic1.setImageResource(R.drawable.lemon)
                4 -> pic1.setImageResource(R.drawable.game7)
            }
            when (generateRandomNumber()) {
                1 -> pic2.setImageResource(R.drawable.bell)
                2 -> pic2.setImageResource(R.drawable.cherries)
                3 -> pic2.setImageResource(R.drawable.lemon)
                4 -> pic2.setImageResource(R.drawable.game7)
            }
            when (generateRandomNumber()) {
                1 -> pic3.setImageResource(R.drawable.bell)
                2 -> pic3.setImageResource(R.drawable.cherries)
                3 -> pic3.setImageResource(R.drawable.lemon)
                4 -> pic3.setImageResource(R.drawable.game7)
            }

            if ((R.id.pic1) == (R.id.pic2) && (R.id.pic2) == (R.id.pic3) && (R.id.pic1) == (R.id.pic3)) {
                lblMessage.text = ("Congrats! You have matched all three numbers and gained 20 coins!")
                counter += 20
                lblCoinCounter.text = ("Coins = " + counter)
            } else if ((R.id.pic1) == (R.id.pic2) || (R.id.pic2) == (R.id.pic3) || (R.id.pic1) == (R.id.pic3)) {
                lblMessage.text = ("Congrats! You have matched two numbers and gained 10 coins!")
                counter += 10
                lblCoinCounter.text = ("Coins = " + counter)
            } else {
                lblMessage.text = ("You did not match any numbers. Lose 15 coins!")
                counter -= 10
                lblCoinCounter.text = ("Coins = " + counter)
            }
        }
    }
}
