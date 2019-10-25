package com.example.anythingisfine.util

import android.view.View

// these functions offer nice visual features that add appeal to the application

// this function causes an object to turn invisible if it helps improve the visual fidelity of the application
fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) {View.INVISIBLE} else { View.VISIBLE }
}

// this is a nice feature that rotates an image each time a button is pressed. it gives a visual appeal each time you click
fun View.rotate90(){
    rotation = (rotation + 90) % 360
}
