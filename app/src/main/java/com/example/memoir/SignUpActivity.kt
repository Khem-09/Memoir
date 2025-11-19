package com.example.memoir

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.memoir.models.DefaultResponse
import com.example.memoir.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonSignUp = findViewById<Button>(R.id.buttonSignUp)


        val textViewGoToLogin = findViewById<android.widget.TextView>(R.id.textViewGoToLogin)

        textViewGoToLogin.setOnClickListener {

            val intent = android.content.Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }

        buttonSignUp.setOnClickListener {
            val username = editTextUsername.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // CALL THE API
            RetrofitClient.instance.createUser(email, password, username)
                .enqueue(object : Callback<DefaultResponse> {
                    override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                        if (response.body()?.error == false) {
                            Toast.makeText(applicationContext, "Success: " + response.body()?.message, Toast.LENGTH_LONG).show()
                            // Navigate to Login or Home here later
                        } else {
                            Toast.makeText(applicationContext, "Error: " + response.body()?.message, Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, "Network Error: " + t.message, Toast.LENGTH_LONG).show()
                    }
                })
        }
    }
}