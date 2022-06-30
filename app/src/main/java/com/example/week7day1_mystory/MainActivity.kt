package com.example.week7day1_mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.CursorAdapter
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private  var recyclerview : RecyclerView? =null
    private var  textViewEmail : TextView?=null
    private  var drawerLyout : DrawerLayout?=null
    private  var toolBar : Toolbar? =null
    private  var navigtionmain : NavigationView?=null
    private  var buttonaddstory :FloatingActionButton?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emmail=intent.getStringExtra("email")
        connectviews()
       //textViewEmail?.text =emmail
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
      //  try {upDataEmailHeader(emmail)
      //  }catch (e:NullPointerException){}
        upDataEmailHeader(emmail)
        drawerclicks()
        openAddStoryActivity()
        displaystories ()


    }
    private  fun  connectviews(){

        textViewEmail=findViewById(R.id.textEmail)
        drawerLyout=findViewById(R.id.drawerlayout)
        toolBar =findViewById(R.id.tolbar)
        navigtionmain =findViewById(R.id.navigtion)
        recyclerview =findViewById(R.id.storiesrecycleview)
        buttonaddstory = findViewById(R.id.btaddstory)
    }
    private  fun setupDrawer(){

        val toggle = ActionBarDrawerToggle(this,drawerLyout,R.string.open,R.string.close)

        drawerLyout?.addDrawerListener(toggle )
        toggle.syncState()
    }
    private  fun upDataEmailHeader( emailupdate :String?){
        val headerview =navigtionmain?.getHeaderView(0)
        val textViewemail =headerview?.findViewById<TextView>(R.id.textEmail)
        textViewemail?.text=emailupdate

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawerLyout?.openDrawer(GravityCompat.START)
                true  }else->true
        }


    }
    private  fun  drawerclicks(){
        navigtionmain?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    drawerLyout?.closeDrawer(GravityCompat.START)
                    true
                }R.id.logout ->{finish()
                val i = Intent(this ,Login ::class.java)
                startActivity(i)

                true
            }
                else ->true
            }
        }
    }
    private  fun openAddStoryActivity(){

       buttonaddstory?.setOnClickListener {
           val i =Intent (this,AddStoryAction ::class.java)
           startActivity(i)
       }

    }
    private  fun displaystories (){

        val storiesArray =ArrayList<Story>()


        storiesArray.add(Story("this is my first story ","this is first subtitle","welcom to my story i will show you how i learn...\n welcom to my story i will show you how i learn...\n welcom to my story i will show you how i learn...\n welcom to my story i will show you how i learn... \n welcom to my story i will show you how i learn... \n welcom to my story i will show you how i learn... \n welcom to my story i will show you how i learn... \n welcom to my story i will show you how i learn..."))
        storiesArray.add(Story("Zthis is my second story ","this is first subtitle","welcom to my story i will show you how i learn..."))
        storiesArray.add(Story("Rthis is my third story ","this is first subtitle","welcom to my story i will show you how i learn..."))


         val customAdapter =customAdapter(storiesArray,this)
recyclerview?.adapter=customAdapter
        if(intent.getStringExtra("title")!=null){

            val title1 = intent.getStringExtra("title")

            val subTitle2 =intent.getStringExtra("subtitle")
            val descripation3 =intent.getStringExtra("descripation")
            val newStory =Story(title1!!,subTitle2!!,descripation3!!)
            storiesArray.add(newStory)
             customAdapter.notifyDataSetChanged()
        }



    }
}