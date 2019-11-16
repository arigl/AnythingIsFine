package com.example.anythingisfine.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.anythingisfine.APIRepository

class GifViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = APIRepository(application.applicationContext);

    fun getRandomGif(name: String) = repository.getRandomGif(name);
}
