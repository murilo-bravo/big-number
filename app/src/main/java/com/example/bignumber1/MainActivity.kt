package com.example.bignumber1

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLeft: Button = findViewById(R.id.btnLeft)
        val btnRight: Button = findViewById(R.id.btnRight)
        val bgView: View = findViewById(R.id.backgroundView)
        val countNum: TextView = findViewById(R.id.countView)
        var counter: Int = 0

        btnLeft.setOnClickListener {
            // code here will run everytime left button is clicked
            // compare numbers in the boxes
            val leftNum = btnLeft.text.toString().toInt()
            val rightNum = btnRight.text.toString().toInt()
            if (leftNum > rightNum) {
                // correct answer
                // change background color
                bgView.setBackgroundColor(Color.GREEN)
                //show a Toast
                Toast.makeText(this, "Acertou!", Toast.LENGTH_SHORT).show()
                counter++
                countNum.text = "Total: $counter"
            } else {
                // wrong answer
                bgView.setBackgroundColor(Color.RED)
                // show a Toast
                Toast.makeText(this, "Errado!", Toast.LENGTH_SHORT).show()
            }
            // pick new random numbers
            val rollLeft = randomLeft().toString()
            val rollRight = randomRight().toString()
            if (rollLeft == rollRight) {
                rollLeft
                rollRight
            } else {
                btnLeft.text = rollLeft
                btnRight.text = rollRight
            }

        }
        btnRight.setOnClickListener {
            val leftNum = btnLeft.text.toString().toInt()
            val rightNum = btnRight.text.toString().toInt()
            if (rightNum > leftNum) {
                bgView.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Acertou!", Toast.LENGTH_SHORT).show()

                counter++
                countNum.text = "Total: $counter"
            } else {
                bgView.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Errado!", Toast.LENGTH_SHORT).show()
            }
            val rollLeft = randomLeft().toString()
            val rollRight = randomRight().toString()
            if (rollLeft == rollRight) {
                rollLeft
                rollRight
            } else {
                btnLeft.text = rollLeft
                btnRight.text = rollRight
            }
        }
    }

    private fun randomLeft(): Int {
        return (0..9).random()
    }
    private fun randomRight(): Int {
        return (0..9).random()
    }
}
