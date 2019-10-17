package com.example.anythingisfine.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.anythingisfine.CountRepository

class CountViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CountRepository(application.applicationContext);

    fun getUserCount(name: String) = repository.getUserCount(name);

    fun setUserCount(name: String, count: Long) = repository.setUsercount(name,count)

}
