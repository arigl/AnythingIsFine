package com.example.anythingisfine

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.anythingisfine.model.Gif
import com.example.anythingisfine.model.GifResponse
import com.example.anythingisfine.network.GiphyApi
import me.ibrahimsn.library.LiveSharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class APIRepository(context: Context){
    private val giphyService: GiphyApi = GiphyApi.create(context)

    fun getRandomGif(username: String): LiveData<Gif>{
        val data = MutableLiveData<Gif>()

        giphyService.getRandomGif(username, "g", API_KEY).enqueue(object: Callback<GifResponse> {
          override fun onResponse(call: Call<GifResponse>, response: Response<GifResponse>){
              data.value = response.body()?.data
          }

          override fun onFailure(call: Call<GifResponse>, t: Throwable){
              // do nothing
          }
        })

        return data
    }

    companion object {
        private const val API_KEY = "pDpbFmyY10lGoAjR0jZEQPI9YrvDxKfz"
    }
}