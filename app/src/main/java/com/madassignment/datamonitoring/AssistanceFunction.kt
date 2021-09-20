package com.madassignment.datamonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AssistanceFunction : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assistance_function)

        val callPhoneSelection: Button = findViewById(R.id.btnCallPhone)
        val backToMainSection: Button = findViewById(R.id.btnBack2)

        callPhoneSelection.setOnClickListener{
            intent = Intent(applicationContext, PhoneCall::class.java)
            startActivity(intent)
        }

        backToMainSection.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}