package com.example.climate

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize DBHelper
        dbHelper = DBHelper(this)

        // Get views
        val usernameEditText = findViewById<EditText>(R.id.usernameRegister)
        val dobEditText = findViewById<EditText>(R.id.dobRegister)
        val phoneEditText = findViewById<EditText>(R.id.phoneRegister)
        val sexRadioGroup = findViewById<RadioGroup>(R.id.sexRadioGroup)
        val emailEditText = findViewById<EditText>(R.id.emailRegister)
        val passwordEditText = findViewById<EditText>(R.id.passwordRegister)
        val registerButton = findViewById<Button>(R.id.registerButton)

        // Handle Register Button click
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val dob = dobEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val selectedSexId = sexRadioGroup.checkedRadioButtonId
            val sex = if (selectedSexId != -1) findViewById<RadioButton>(selectedSexId).text.toString() else ""
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || dob.isEmpty() || phone.isEmpty() || sex.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val success = dbHelper.insertUser(username, dob, phone, sex, email, password)

                if (success) {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                    finish() // Navigate back to login screen
                } else {
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
