package com.example.splashactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgressCounter : TextView
    private val maxProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        progressBar = findViewById(R.id.progressBar)
        tvProgressCounter = findViewById(R.id.tvProgressCounter)

        val countdownHandler = Handler()
        val maxProgress = 100
        var countdownValue = 6 //set to 6 to start at 5 on Run

        countdownHandler.postDelayed(object : Runnable {
            override fun run() {
                countdownValue -= 1
                progressBar.progress = ((5 - countdownValue) * (maxProgress / 5))
                tvProgressCounter.text = countdownValue.toString()

                if (countdownValue > 0) {
                    countdownHandler.postDelayed(this, 1000) // 1000 milliseconds = 1 second
                } else {
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }, 1000) // Delay the start of the countdown if needed
    }
}