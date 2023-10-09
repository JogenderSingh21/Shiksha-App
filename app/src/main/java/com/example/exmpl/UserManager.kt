package com.example.exmpl

import android.content.Context
import android.content.SharedPreferences
import com.example.exmpl.Model.UserData

class UserManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_pref", Context.MODE_PRIVATE)

    // Register a new user
    fun registerUser(name: String, email: String, password: String, userClass: String) {
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.putString("class", userClass)
        editor.apply()
    }

    // Check if a user is already registered
    private fun isUserRegistered(): Boolean {
        return sharedPreferences.contains("email") && sharedPreferences.contains("password")
    }

    // Check if login credentials are valid
    fun isLoginValid(email: String, password: String): Boolean {
        val savedEmail = sharedPreferences.getString("email", null)
        val savedPassword = sharedPreferences.getString("password", null)
        return savedEmail == email && savedPassword == password
    }

    // Retrieve user data
    fun getUserData(): UserData? {
        if (isUserRegistered()) {
            val name = sharedPreferences.getString("name", null)
            val email = sharedPreferences.getString("email", null)
            val userClass = sharedPreferences.getString("class", null)
            return UserData(name, email, userClass)
        }
        return null
    }
}
