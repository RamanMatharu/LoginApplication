package com.ramanmatharu.loginapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    lateinit var signUp : TextView
    lateinit var email : EditText
    lateinit var passwd : EditText
    lateinit var mobile: EditText
    lateinit var mentionHere: EditText
    lateinit var radioGrp : RadioGroup
    lateinit var male : RadioButton
    lateinit var female : RadioButton
    lateinit var other : RadioButton
    lateinit var registerBtn: Button
    var emaill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        intent?.extras?.let{
            emaill = it.getString("email","")
        }
        //setting title

        supportActionBar?.title = "Registration"

        //initialization
        signUp = findViewById(R.id.signUp)
        email = findViewById(R.id.email)
        passwd = findViewById(R.id.passwd)
        mobile = findViewById(R.id.mobile)
        radioGrp = findViewById(R.id.gender)
        mentionHere = findViewById(R.id.mentionHere)
        registerBtn = findViewById(R.id.registerBtn)
        female = findViewById(R.id.female)
        male = findViewById(R.id.male)
        other = findViewById(R.id.other)



        signUp.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        radioGrp.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.female -> mentionHere.visibility = View.GONE
                R.id.male -> mentionHere.visibility= View.GONE
                else -> mentionHere.visibility = View.VISIBLE
            }
        }

        //validation

        registerBtn.setOnClickListener {
            if(email.text.toString().isEmpty()){
                email.error="It is mandatory to enter email"
            }else if(passwd.text.toString().isEmpty()){
                passwd.error="It is mandatory to secure your account"
            }else if(passwd.text.toString().length<6) {
                passwd.error = "Password must be of 6 characters"
            }else if(mobile.text.toString().length < 10){
                mobile.error="Mobile number must be of 10 digits"
            }else if(mobile.text.toString().isEmpty()) {
                mobile.error = "It is mandatory to provide mobile number"
            }else if(radioGrp.checkedRadioButtonId == -1){
                Toast.makeText(this,"It is mandatory to choose gender",Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(this,"Registration is successful!",Toast.LENGTH_LONG).show()
            }
        }
    }
}
