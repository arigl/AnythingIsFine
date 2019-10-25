package com.example.anythingisfine.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.anythingisfine.CountRepository

class CountViewModel(application: Application) : AndroidViewModel(application) {
    // Part of the Model View Model System layout
    // Takes in a repository for an object oriented approach
    // Initializes the functions for getting the user count to back up to a repository
    // Initializes the function for setting the user count attached to a name to the repository 
    private val repository = CountRepository(application.applicationContext);

    fun getUserCount(name: String) = repository.getUserCount(name);

    fun setUserCount(name: String, count: Long) = repository.setUsercount(name,count)

}
