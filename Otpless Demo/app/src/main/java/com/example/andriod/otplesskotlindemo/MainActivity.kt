package com.example.andriod.otplesskotlindemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseOtplessIntent(intent)
        setContentView(R.layout.activity_main)
        var button = findViewById(R.id.button_open_auth_link) as Button
        button.setOnClickListener {
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://gauge.authlink.me")
            )
            startActivity(urlIntent)
        }
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        parseOtplessIntent(intent)
    }

    private fun parseOtplessIntent(intent: Intent?) {
        if (intent != null && intent.data != null && intent.data!!.host!!.contains("otpless")) {
            val redirectUri = intent.data
            println(redirectUri)
            val waId = redirectUri!!.getQueryParameter("waId")
            println(waId)
            if (waId != null) {
                Toast.makeText(this, waId, Toast.LENGTH_SHORT).show()
            }
        }
    }
}