package com.example.exmpl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginToReg = findViewById<TextView>(R.id.loginToReg)
        loginToReg.setOnClickListener{
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

        val userManager = UserManager(this)
        val loginBtn = findViewById<Button>(R.id.logBtn)
        val loginEmail = findViewById<EditText>(R.id.logEmail)
        val loginPassword = findViewById<EditText>(R.id.logPassword)

        loginBtn.setOnClickListener {
            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()

            if (userManager.isLoginValid(email, password)) {
                // Login successful, proceed to the next screen or perform actions
                Toast.makeText(this@LoginActivity, "Login Successful...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@LoginActivity, "Wrong Credentials!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}