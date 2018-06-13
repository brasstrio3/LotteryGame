package com.example.administrator.lotterygame

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.Bitmap



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

            /*Log.e("Pic2 is showing", pic2.getDrawable().toString())
            Log.e("Pic1 is showing", pic1.getDrawable().toString())
            Log.e("Pic3 is showing", pic3.getDrawable().toString())
            Log.e("Is pic2 = pic1", pic1.getDrawable().toString().equals(pic2.getDrawable().toString()).toString())

            val bitmap = (pic1.getDrawable() as BitmapDrawable).bitmap
            val bitmap2 = (pic2.getDrawable() as BitmapDrawable).bitmap

            if (bitmap == bitmap2) {
                Log.e("Pic2 is showing", pic2.getDrawable().toString())
            }*/

            if (pic1.getDrawable().toString() == pic2.getDrawable().toString() &&
                    pic2.getDrawable().toString() == pic3.getDrawable().toString() &&
                    pic1.getDrawable().toString() == pic3.getDrawable().toString()) {

                lblMessage.text = ("Congrats! You have matched all three numbers and gained 20 coins!")
                counter += 20
                lblCoinCounter.text = ("Coins = " + counter)
            } else if (pic1.getDrawable().toString() == pic2.getDrawable().toString() ||
                    pic2.getDrawable().toString() == pic3.getDrawable().toString() ||
                    pic1.getDrawable().toString() == pic3.getDrawable().toString()) {
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
