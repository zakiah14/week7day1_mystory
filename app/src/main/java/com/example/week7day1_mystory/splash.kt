package com.example.week7day1_mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToLoginScreen()

    }
    private fun   moveToLoginScreen(){
        Handler(Looper.myLooper()!!).postDelayed({
            finish()
            val i = Intent(this,Login::class.java)
            startActivity(i)

        },2000)


    }
    }
