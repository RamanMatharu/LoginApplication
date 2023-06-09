package com.ramanmatharu.loginapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var login : Button
    lateinit var register_msg : TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        register_msg = findViewById(R.id.register_msg)

        //validation
        login.setOnClickListener {
            if(username.text.toString().isEmpty()){
                username.error = "Enter your username"
            }else if(password.text.toString().isEmpty()){
                password.error = "Enter your password"
            }else{
                Toast.makeText(this,"Login Successfully",Toast.LENGTH_LONG).show()
            }
        }

        register_msg.setOnClickListener {
            register_msg.setTextColor(Color.parseColor("#1A78CC"))
            var intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
//            finish()
        }


    }
}
