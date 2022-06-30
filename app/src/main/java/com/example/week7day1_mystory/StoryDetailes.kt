package com.example.week7day1_mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class StoryDetailes : AppCompatActivity() {

    private  var  toolbar :Toolbar? =null
     private var textVewsDetiles :TextView ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_detailes)
        connectviews()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val title =intent.getStringExtra("title")
        val descrption = intent.getStringExtra("desc")
        supportActionBar?.title=title
        toolbar?.setNavigationOnClickListener {
          onBackPressed()}
            textVewsDetiles?.text=descrption
        textVewsDetiles?.movementMethod=ScrollingMovementMethod() //تستخدم لما يكون النص طويل  في الصفحة عشان نحركه للاسفل
    }
    private  fun  connectviews(){

       toolbar =findViewById(R.id.toolbardetiles)
       textVewsDetiles =findViewById(R.id.tvdetiles)

    }
}