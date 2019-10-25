package com.example.anythingisfine.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.anythingisfine.R
import com.example.anythingisfine.util.rotate90
import com.example.anythingisfine.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(){
    private lateinit var countViewModel: CountViewModel

    private var whaleCounter: Long = 0 // stores the main counter value before initiation as a long 
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US) // takes in the username from the login activity and formats it 

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // sets the activity to display on the content view 

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java) 
        countViewModel.getUserCount(getUsername()).observe(this, androidx.lifecycle.Observer{updateCounter(it)})

        myButton.setOnClickListener{
            // when the button is clicked, it increases the value of the counter and then saves it on the corresponding username
            countViewModel.setUserCount(getUsername(), whaleCounter + 1)
            
            // Exectutes a method that rotates the image for visual appeal 
            myImage.rotate90()
        }

        restartButton.setOnClickListener{
            // allows a user to restart their counter without having to change usernames 
            whaleCounter = 0;
            CounterText.setText(""+whaleCounter);
        }
    }

    private fun updateCounter(count: Long){
        // updates the counter and converts the text to the new value 
        whaleCounter = count
        CounterText.text = whaleCounter.toString()
    }
}
