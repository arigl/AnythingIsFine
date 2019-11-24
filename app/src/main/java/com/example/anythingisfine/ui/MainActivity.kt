package com.example.anythingisfine.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.anythingisfine.R
import com.example.anythingisfine.model.Gif
import com.example.anythingisfine.util.ExampleService
import com.example.anythingisfine.viewmodel.GifViewModel
import com.example.anythingisfine.util.rotate90
import com.example.anythingisfine.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(){
    private lateinit var countViewModel: CountViewModel
    private lateinit var gifViewModel: GifViewModel

    private var input: String = ""

    private var whaleCounter: Long = 0
    private fun getUsername() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount(getUsername()).observe(this, androidx.lifecycle.Observer{updateCounter(it)})

        gifViewModel = ViewModelProviders.of(this).get(GifViewModel::class.java)
        gifViewModel.getRandomGif(getUsername()).observe(this,androidx.lifecycle.Observer { loadGif(it) })



        myButton.setOnClickListener{
            countViewModel.setUserCount(getUsername(), whaleCounter + 1)
            myImage.rotate90()
        }

        restartButton.setOnClickListener{
            whaleCounter = 0
            CounterText.setText(""+whaleCounter)
        }
    }

    public fun startService(v: View) {
        input = intent.extras?.get("username").toString().toLowerCase(Locale.US)

        intent = Intent(this,ExampleService::class.java)
        intent.putExtra("inputExtra", input)

        startService(intent)

    }

    public fun stopService(v: View){
        intent = Intent(this, ExampleService::class.java)
        stopService(intent)
    }

    private fun updateCounter(count: Long){
        whaleCounter = count
        CounterText.text = whaleCounter.toString()
    }

    private fun loadGif(gif: Gif){
        Glide.with(this)
            .load(gif.url)
            .into(gifImage)
    }
}