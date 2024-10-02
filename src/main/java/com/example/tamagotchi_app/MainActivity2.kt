package com.example.tamagotchi_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {


    // Pet attributes
    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50
    private var petHappiness = 50

    // Constants for attribute changes
    private val hungerChange = 10
    private val cleanlinessChange = 10
    private val healthChange = 10
    private val hungerAfterPlay = 5
    private val cleanlinessAfterPlay = -5
    private val happinessChange = 10

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Declaring variables
        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnClean = findViewById<Button>(R.id.btnClean)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val Pethungry = findViewById<EditText>(R.id.Pethungry)
        val Petclean = findViewById<EditText>(R.id.Petclean)
        val Pethappy = findViewById<EditText>(R.id.Pethappy)
        val Petimage =findViewById<ImageView>(R.id.Petimage)

        // Display initial values
        Pethungry.setText(petHunger.toString())
        Petclean.setText(petCleanliness.toString())
        Pethappy.setText(petCleanliness.toString())

        // code for what happens when the feed button is clicked
        btnFeed.setOnClickListener{
            petHunger  += hungerChange
            petHealth += healthChange
            // Ensure attributes stay within bounds
            petHunger = petHunger.coerceIn(0, 100)
            petHealth = petHealth.coerceIn(0, 100)
            petCleanliness = petCleanliness.coerceIn(0, 100)
            Pethungry.setText(petHunger.toString())
            Petclean.setText(petCleanliness.toString())
            animatedImageChange(Petimage, R.drawable.feeding)
        }

        // code for what happens when the clean button is clicked
        btnClean.setOnClickListener {
            petCleanliness += cleanlinessChange
            petHealth += healthChange
            // Ensure attributes stay within bounds
            petCleanliness = petCleanliness.coerceIn(0, 100)
            petHealth = petHealth.coerceIn(0, 100)
            Petclean.setText(petCleanliness.toString())
            animatedImageChange(Petimage, R.drawable.bathing)
        }

        // code for what happens when the play button is clicked
        btnPlay.setOnClickListener {
            petHunger -= hungerAfterPlay
            petCleanliness += cleanlinessAfterPlay
            petHappiness += happinessChange
            petHealth += healthChange
            // Ensure attributes stay within bounds
            petHealth = petHealth.coerceIn(0, 100)
            petHunger = petHunger.coerceIn(0, 100)
            petCleanliness = petCleanliness.coerceIn(0, 100)
            petHappiness = petHappiness.coerceIn(0, 100)
            Pethappy.setText(petHappiness.toString())
            Pethungry.setText(petHunger.toString())
            Petclean.setText(petCleanliness.toString())
            animatedImageChange(Petimage, R.drawable.happy)
        }

    }

    // function for changing the images when the buttons are clicked
    private fun animatedImageChange(imageView: ImageView, newImageResource: Int) {
        val  animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}

