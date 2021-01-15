package com.gauravthapa.week6assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etUSERNAME : EditText
    private lateinit var etPASSWORD : EditText
    private lateinit var btnLOGIN : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etUSERNAME = findViewById(R.id.USERNAME)
        etPASSWORD = findViewById(R.id.PASSWORD)
        btnLOGIN = findViewById(R.id.SUBMIT)


        btnLOGIN.setOnClickListener {
            if(validateInput()) {
                val username = etUSERNAME.getText().toString()
                val password = etPASSWORD.getText().toString()
                if (username == "softwarica" && password == "coventry") {
                    Toast.makeText(
                        this@MainActivity,
                        "User Succesfully Logged in",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this, Home_Activity::class.java)
                    startActivity(intent)
                } else {
                    etUSERNAME.setText("");
                    etPASSWORD.setText("");
                    etUSERNAME.requestFocus()
                    Toast.makeText(this@MainActivity, "Invalid Username or Password", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun validateInput(): Boolean {
        var result : Boolean = true
        when {
            TextUtils.isEmpty(etUSERNAME.text) -> {
                etUSERNAME.error = "This field should not be empty"
                etUSERNAME.requestFocus()
                result = false
            }
            TextUtils.isEmpty(etPASSWORD.text) -> {
                etPASSWORD.error = "This field should not be empty"
                etPASSWORD.requestFocus()
                result = false
            }
        }
        return result
    }
}