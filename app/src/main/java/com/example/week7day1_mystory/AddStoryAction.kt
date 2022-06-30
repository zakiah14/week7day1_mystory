package com.example.week7day1_mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.week7day1_mystory.R.string.enterTitle

class AddStoryAction : AppCompatActivity() {
    private  var ettitle :EditText ?=null
    private   var subttle :EditText ? = null
    private  var description :EditText ?= null
    private  var  btadd :Button ? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story_action)

        connectviews()
        fieldsValidation()
    }
     private  fun   connectviews(){
         ettitle =findViewById(R.id.etTitle)
          subttle =findViewById(R.id.etsubtitle)
          description=findViewById(R.id.etdescripation)
         btadd=findViewById(R.id.btnAdd)
     }
    private  fun fieldsValidation(){
        btadd?.setOnClickListener{
            val titlee =ettitle?.text.toString()
            val  subtitle =subttle?.text.toString()
            val desc=description?.text.toString()
            if (titlee.isEmpty()){
                ettitle?.setError(getString(enterTitle))
            }else if (subtitle.isEmpty()){
                subttle?.setError(getString(R.string.enter_sub_title))

            }
            else if (desc.isEmpty()){
                description?.setError(getString(R.string.enter_descrpition))


            }
            else{
             this.finish()
                val i =Intent (this,MainActivity ::class.java)
                i.putExtra("title",titlee)
                i.putExtra("subtitle",subtitle)
                i.putExtra("descripation",desc)

                startActivity(i)
            }
        }




    }
}