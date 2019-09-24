package com.example.anythingisfine

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextWatcher
import android.text.Editable
import android.content.Intent
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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
            startActivity(Intent(this, MainActivity::class.java).apply{putExtra("username", loginUsernameField.text)})
        }
    }

}
