package com.example.anythingisfine

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.anythingisfine.util.rotate90
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import androidx.core.app.NotificationCompat.getExtras
import android.R.layout
import android.widget.ImageButton







class MainActivity : AppCompatActivity() {
    private var counter: Long =  0
    fun getStore() = getPreferences(Context.MODE_PRIVATE)
    val map = HashMap<String, Long>()
    var USERNAME_COUNTER_KEY: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.extras?.get("username").toString().trim()
        USERNAME_COUNTER_KEY = username

        if (savedInstanceState != null){
            updateCounter(savedInstanceState.getLong(USERNAME_COUNTER_KEY, 0))
        } else if (getStore().contains(USERNAME_COUNTER_KEY)){
            updateCounter(getStore().getLong(USERNAME_COUNTER_KEY, 0))
        }


        /*
        if (map[username] != null){
            getUserValue(username!!)
        }
        else{
            storeUsername(username!!)
        }

        //counter = map["Alex"]
        */
        myButton.setOnClickListener {
                counter++
                CounterText.setText(""+counter);
                myImage.rotate90()
        }
        restartButton.setOnClickListener{
            counter = 0;
            CounterText.setText(""+counter);
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run{
            putLong(USERNAME_COUNTER_KEY, counter)
        }

        super.onSaveInstanceState(outState)
    }

    private fun updateCounter(count: Long){
        counter = count
        CounterText.text = counter.toString()
    }

    override fun onPause(){
        super.onPause()
        getStore().edit().putLong(USERNAME_COUNTER_KEY, counter).apply()
    }
    companion object {
        private const val USERNAME_COUNTER_KEY = "Counter"
    }
}