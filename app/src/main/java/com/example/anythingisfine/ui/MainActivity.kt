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

    private var whaleCounter: Long = 0
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this, androidx.lifecycle.Observer{updateCounter(it)})

        myButton.setOnClickListener{
            countViewModel.setUserCount(getUsername(), whaleCounter + 1)
            myImage.rotate90()
        }

        restartButton.setOnClickListener{
            whaleCounter = 0;
            CounterText.setText(""+whaleCounter);
        }
    }

    private fun updateCounter(count: Long){
        whaleCounter = count
        CounterText.text = whaleCounter.toString()
    }
}