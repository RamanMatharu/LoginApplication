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
    lateinit var registerMsg : TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.userName)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        registerMsg = findViewById(R.id.registerMsg)

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

        registerMsg.setOnClickListener {
            registerMsg.setTextColor(Color.parseColor("#1A78CC"))
            var email = username.text.toString()
            var intent = Intent(this,RegistrationActivity::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
//            finish()
        }


    }
}
