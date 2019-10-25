package com.example.anythingisfine

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import me.ibrahimsn.library.LiveSharedPreferences


class CountRepository(context: Context){
    // Serves as the repository to store the variables through instances
    // allows for usernames to be connected to their respective counter values 
    private val preferences: SharedPreferences
    private val liveSharedPreferences: LiveSharedPreferences

    init{
        // allows for variables to persist even when the application is closed
        preferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        liveSharedPreferences = LiveSharedPreferences(preferences)
    }

    fun setUsercount(name: String, count: Long){
        // sets the new user count to its corresponding counter "count"
        preferences.edit().putLong(name, count).apply()
    }

    fun getUserCount(name: String): LiveData<Long> =
        // when the username is called, it gets the counter variable from liveshared preferences
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), 0L)) {it[name]}

    companion object {
        private const val PREFS = "clickCounts"
    }
}
