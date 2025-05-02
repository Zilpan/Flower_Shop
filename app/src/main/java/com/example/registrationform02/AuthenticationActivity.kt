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

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_authentication)
        val userLogin = findViewById<EditText>(R.id.userLoginAuth)
        val userPassword = findViewById<EditText>(R.id.userPasswordAuth)
        val buttonReg = findViewById<Button>(R.id.buttonAuth)
        val linkToReg = findViewById<TextView>(R.id.linkToReg)

        buttonReg.setOnClickListener {
            var login = userLogin.text.toString().trim()
            var password = userPassword.text.toString().trim()

            if (login == "" ||  password == "")
                Toast.makeText(this, "Fill all required information", Toast.LENGTH_LONG).show()
            else {

                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, password)
                if (isAuth) {
                    Toast.makeText(this, "User $login logged in successfully", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()
                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Incorrect login or password", Toast.LENGTH_LONG).show()
                }

            }
        }

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}