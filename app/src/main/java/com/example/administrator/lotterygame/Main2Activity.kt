package com.example.administrator.lotterygame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        spin()
        setBet()
        setOnClickListenerForExit()
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
        var counter = (getIntent().getExtras().getInt("Coins"))
        lblCoinCounter.text = ("Coins = " + counter)

        var firstPic: Int = 0
        var secondPic: Int = 0
        var thirdPic: Int = 0

        btnSpin.setOnClickListener() {
            when (generateRandomNumber()) {
                1 -> {
                    pic1.setImageResource(R.drawable.bell)
                    firstPic = 1
                }
                2 -> {
                    pic1.setImageResource(R.drawable.cherries)
                    firstPic = 2
                }
                3 -> {
                    pic1.setImageResource(R.drawable.lemon)
                    firstPic = 3
                }
                4 -> {
                    pic1.setImageResource(R.drawable.game7)
                    firstPic = 4
                }
            }
            when (generateRandomNumber()) {
                1 -> {
                    pic2.setImageResource(R.drawable.bell)
                    secondPic = 1
                }
                2 -> {
                    pic2.setImageResource(R.drawable.cherries)
                    secondPic = 2
                }
                3 -> {
                    pic2.setImageResource(R.drawable.lemon)
                    secondPic = 3
                }
                4 -> {
                    pic2.setImageResource(R.drawable.game7)
                    secondPic = 4
                }
            }
            when (generateRandomNumber()) {
                1 -> {
                    pic3.setImageResource(R.drawable.bell)
                    thirdPic = 1
                }
                2 -> {
                    pic3.setImageResource(R.drawable.cherries)
                    thirdPic = 2
                }
                3 -> {
                    pic3.setImageResource(R.drawable.lemon)
                    thirdPic = 3
                }
                4 -> {
                    pic3.setImageResource(R.drawable.game7)
                    thirdPic = 4
                }
            }

            if (firstPic == secondPic && secondPic == thirdPic && firstPic == thirdPic) {
                lblMessage.text = "Congrats! You have matched all three pictures and gained 25 coins!"
                counter += (counter / (counter / 2))
                lblCoinCounter.text = "Coins = " + counter
            }
            else if (firstPic == secondPic || secondPic == thirdPic || firstPic == thirdPic){
                lblMessage.text = "Congrats! You have matched two pictures and gained 5 coins!"
                counter += 5
                lblCoinCounter.text = "Coins = " + counter
            }
            else {
                lblMessage.text = "Sorry, you did not match any pictures. Lose 10 coins..."
                counter -= 10
                lblCoinCounter.text = "Coins = " + counter
            }
        }
    }

    /*TODO: btnCustom needs to open a numeric textfield and allow user to input custom number.
        Then it needs to validate that the number entered is not greater than the amount that they have
     */
    private fun setBet() {
        var bet = 0
        var counter = (getIntent().getExtras().getInt("Coins"))

        btnAdd.setOnClickListener {
            bet += 5
            lblBetAmount.text = bet.toString()
        }

        btnSubtract.setOnClickListener {
            bet -= 5
            lblBetAmount.text = bet.toString()
        }

        btnCustom.setOnClickListener {

        }

        btnAll.setOnClickListener {
            bet = counter
            lblBetAmount.text = bet.toString()
        }
    }

    private fun setOnClickListenerForExit() {
        var counter = (getIntent().getExtras().getInt("Coins"))

        btnExit.setOnClickListener {
            val intent = Intent("com.example.administrator.lotterygame.Main3Activity")
            intent.putExtra("Coins", counter)
            startActivity(intent)
        }
    }
}
