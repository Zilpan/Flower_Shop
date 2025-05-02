package com.example.flowershop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEmail = findViewById<EditText>(R.id.userEmail)
        val userLogin = findViewById<EditText>(R.id.userLogin)
        val userPassword = findViewById<EditText>(R.id.userPassword)
        val buttonReg = findViewById<Button>(R.id.buttonReg)
        val linkToAuth = findViewById<TextView>(R.id.linkToAuth)

        buttonReg.setOnClickListener {
            var login = userLogin.text.toString().trim()
            var email = userEmail.text.toString().trim()
            var password = userPassword.text.toString().trim()

            if (login == "" || email == "" || password == "")
                Toast.makeText(this, "Fill all required information", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, password)
                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "User $login was added", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }
        }

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthenticationActivity::class.java)
            startActivity(intent)
        }
    }
}