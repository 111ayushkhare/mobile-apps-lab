package com.example.splashplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Changing to default theme after SplashScreen
        setTheme(R.style.Theme_SplashPlay)

        setContentView(R.layout.activity_main)
    }
}