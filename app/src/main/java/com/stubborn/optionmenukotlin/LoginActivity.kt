package com.stubborn.optionmenukotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {


    val MIN_PASSWORD_LENGTH = 6
    val mail = "wish75584@gmail.com"
    val pass = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)

        val si_name1 = findViewById<EditText>(R.id.si_name1)
        val si_pass = findViewById<EditText>(R.id.si_pass)
        val submit_area = findViewById<Button>(R.id.submit_area)

    Toast.makeText(this,"Welcome to Login Page",Toast.LENGTH_LONG).show()

        submit_area.setOnClickListener {
            if (validate()) {
                Toast.makeText(this,"Done",Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("email",si_name1.text.toString())
                intent.putExtra("password",si_pass.text.toString())

                startActivity(intent)
            }
        }
    }

    private fun validate(): Boolean {
        if (si_name1.text.toString().isEmpty() || si_name1.text.toString() != mail) {
            // si_name1.setError("Enter Username",R.drawable.ic_error_black_24dp)
            si_name1.error = "Username is not correct"
            //Toast.makeText(this!!, "Username is not correct", Toast.LENGTH_SHORT).show()
            return false
        } else if (si_pass.text.toString().isEmpty() || si_pass.text.toString() != pass) {
            si_pass.error = "Password is incorrect"
            return false
        }
        return true;
    }

    fun openSignup(view: View) {
        val intent = Intent(this,SignUpActivity::class.java)
    }

}

