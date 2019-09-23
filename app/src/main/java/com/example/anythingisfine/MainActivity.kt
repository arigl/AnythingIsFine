package com.example.anythingisfine

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.anythingisfine.util.rotate90
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var counter: Long =  0
    fun getStore() = getPreferences(Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null){
            counter = savedInstanceState.getLong(COUNTER_KEY, 0)
        }
        myButton.setOnClickListener {
                counter++
                CounterText.setText(""+counter);
                myImage.rotate90()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run{
            putLong(COUNTER_KEY, counter)
        }

        super.onSaveInstanceState(outState)
    }

    override fun onPause(){
        super.onPause()
        getStore().edit().putLong(COUNTER_KEY, counter).apply()
    }
    companion object {
        private const val COUNTER_KEY = "Counter"
    }
}