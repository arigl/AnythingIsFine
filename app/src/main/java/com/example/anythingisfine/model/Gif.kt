package com.example.anythingisfine.model

import com.google.gson.annotations.SerializedName

class GifResponse(@SerializedName("data") val data: Gif)

class Gif(@SerializedName("image.url") val url: String)