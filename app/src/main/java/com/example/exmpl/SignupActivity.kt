package com.example.exmpl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val regToLogin = findViewById<TextView>(R.id.regToLogin)
        regToLogin.setOnClickListener{
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val userManager = UserManager(this)
        val regBtn = findViewById<Button>(R.id.regBtn)
        val regName = findViewById<EditText>(R.id.regName)
        val regEmail = findViewById<EditText>(R.id.regEmail)
        val regPassword = findViewById<EditText>(R.id.regPassword)
        val regClass = findViewById<EditText>(R.id.regClass)

        regBtn.setOnClickListener {
            val name = regName.text.toString()
            val email = regEmail.text.toString()
            val password = regPassword.text.toString()
            val userClass = regClass.text.toString()

            userManager.registerUser(name, email, password, userClass)

            Toast.makeText(this@SignupActivity, "Successfully Registered!! Login Now...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}