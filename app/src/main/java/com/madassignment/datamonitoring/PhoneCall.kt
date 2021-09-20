package com.madassignment.datamonitoring

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.google.firebase.database.FirebaseDatabase

class PhoneCall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_call)

        val backToSelection: Button = findViewById(R.id.btnBack3)

        val personName: EditText = findViewById(R.id.editPersonName)
        val phoneNumber: EditText = findViewById(R.id.editPhoneNumber)
        val remarks: EditText = findViewById(R.id.editRemarks)

        backToSelection.setOnClickListener {
            intent = Intent(applicationContext, AssistanceFunction::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnCallNow).setOnClickListener{
            val phoneCallDatabase =  FirebaseDatabase.getInstance()
            val pcReference = phoneCallDatabase.getReference("CallHistoryRecord")

            val name: String = personName.text.toString()
            val phoneNum: String = phoneNumber.text.toString()
            val inputRemarks: String = remarks.text.toString()

            if(name.isEmpty()) {
                Toast.makeText(applicationContext, "Please fill the name.", Toast.LENGTH_SHORT).show()
            }

            else {
                when {
                    phoneNum.isEmpty() -> {
                        Toast.makeText(
                            applicationContext,
                            "Please fill the phone number.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    !phoneNum.isDigitsOnly() ->{
                        Toast.makeText(
                            applicationContext,
                            "Please fill phone number based on phone format.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    inputRemarks.isEmpty() -> {
                        Toast.makeText(
                            applicationContext,
                            "Please fill the remarks.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        val phoneCallIntent = Intent(Intent.ACTION_DIAL)

                        Toast.makeText(this@PhoneCall, "The information for phone call record added.", Toast.LENGTH_SHORT).show()

                        phoneCallIntent.data = Uri.parse("tel:$phoneNum")
                        startActivity(phoneCallIntent)

                        val ch = CallHistoryRecord(name, phoneNum, inputRemarks)

                        pcReference.child(ch.name).setValue(ch)
                    }
                }
            }
        }
    }
}