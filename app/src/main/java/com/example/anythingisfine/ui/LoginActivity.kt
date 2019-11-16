package com.example.anythingisfine.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextWatcher
import android.text.Editable
import android.content.Intent
import com.example.anythingisfine.R
import kotlinx.android.synthetic.main.content_login.*

// This Activity is used to take in username that will store the counter value to be referenced later 
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_login) // set the shown activity as the login page 

        loginUsernameField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){
                //unused
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){
                //unused
            }
            override fun afterTextChanged(p0: Editable?){
                //unused
            }
        })

        loginButton.setOnClickListener{
            // when the login button is clicked, pass on the username to the main activity 
            startActivity(Intent(this, MainActivity::class.java).apply{putExtra("username", loginUsernameField.text)})
        }
    }

}
