package com.example.testsample

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testsample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val launchIntent = intent
        if (launchIntent.action == "com.google.intent.action.TEST_LOOP") {
            val scenario = launchIntent.getIntExtra("scenario", 0)
            // Code to handle your game loop here
            intentAndBackNavigation()
        } else {
            intentAndBackNavigation()
        }

        SecondActivity().finish()
    }

    private fun intentAndBackNavigation() {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // jumping to email app on button click
        try {
            binding.buttonSecond2.setOnClickListener {
                val emailAddresses = binding.emailAddr.text.toString().split(",").toTypedArray()
                val subject = binding.emailSubj.text.toString()
                val body = binding.emailBody.text.toString()

                val intent = Intent(Intent.ACTION_SENDTO)
                    .setData(Uri.parse("mailto:"))
                    .putExtra(Intent.EXTRA_EMAIL, emailAddresses)
                    .putExtra(Intent.EXTRA_SUBJECT, subject)
                    .putExtra(Intent.EXTRA_TEXT, body)

                val emailIntent = Intent.createChooser(intent, "Sending mail...")

                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(emailIntent)
                }

                Toast.makeText(this, "Sending mail...", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Could not draft mail...", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSecond.setOnClickListener {
            onBackPressed()
        }
    }
}