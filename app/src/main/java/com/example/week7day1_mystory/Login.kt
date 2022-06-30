package com.example.week7day1_mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    private var textuser: EditText? =null
    private var textPassword: EditText? =null
    private var buttonLogin: Button? =null
    private var checkBoxLogin: CheckBox? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        conectedViews()
        checkFields()


    }
    private  fun conectedViews(){
        textuser =findViewById(R.id.userName)
        textPassword =findViewById(R.id.password)
        checkBoxLogin=findViewById(R.id.checkBoxLogin)
        buttonLogin =findViewById(R.id.buttonlogin)

    }
    private fun  login() {
        val arr: ArrayList<User> = ArrayList()
        arr.add(User("zakiah@test.com", "000000"))
        arr.add(User("mha@test.com", "111111"))
        arr.add(User("roan@test.com", "222222"))

            val nameTest = textuser?.text.toString()
            val passswordTest = textPassword?.text.toString()
            //لازم اسوي اوبجكت اثنين عشان اقارن بينهل واتحقق
            val user = User(nameTest, passswordTest)
            for (i in arr) {
                if (i.name == user.name && i.password == user.password) {
                //    Toast.makeText(this, "welcome ${user.name}", Toast.LENGTH_LONG).show()
finish()
                    val b = Intent(this, MainActivity::class.java)
                    b.putExtra("email", i.name)
                    startActivity(b)
                    break
                } else {
                    Toast.makeText(this, "check your data", Toast.LENGTH_LONG).show()
                    break
                }
            }
        }
    private  fun checkFields(){
        buttonLogin?.setOnClickListener {

            if (textuser?.text?.isEmpty() == true) {
                // Toast.makeText(this, "Enter your data", Toast.LENGTH_LONG).show()
                textuser?.setError("enter your email")
            } else if(textPassword?.text?.isEmpty() == true ) {textPassword?.setError("enter your password")}
           else if( checkBoxLogin?.isChecked==false){
                Toast.makeText(this, "check the box", Toast.LENGTH_LONG).show()

           }
           else {login()}
        }
    }
}