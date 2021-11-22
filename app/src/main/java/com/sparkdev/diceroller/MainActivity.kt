package com.sparkdev.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //Do a dice roll when app is Launched
        rollDice()
    }
/**
* Create a Dice and update screen with the results
 **/
    private fun rollDice() {
    //Create a new dice objects and roll both
        val myFirstDice = Dice(6)
        val mySecondDice = Dice(6)
        val firstDiceRoll = myFirstDice.roll()
        val secondDiceRoll = mySecondDice.roll()

    //Find image view in the layout
        val firstDiceImage : ImageView = findViewById(R.id.imageView)
        val secondDiceImage : ImageView = findViewById(R.id.imageView2)

    fun diceImage(image: Int): Int {
        //Determine which Drawable resource ID to use based on the number rolled
        return when (image) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    //Update screen with the selected drawable resource ID
        val firstDisplay = diceImage(firstDiceRoll)
        firstDiceImage.setImageResource(firstDisplay)

        val secondDisplay = diceImage(secondDiceRoll)
        secondDiceImage.setImageResource(secondDisplay)

    //Update the content description
        firstDiceImage.contentDescription = firstDiceRoll.toString()
        secondDiceImage.contentDescription = secondDiceRoll.toString()

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}