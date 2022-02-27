package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    private lateinit var mail: TextView
    private lateinit var password: TextView
    private lateinit var registration: Button
    private lateinit var already: TextView
    lateinit var username: EditText
    lateinit var dateOfBirth: EditText
    lateinit var phone: EditText
    lateinit var photoUrl: EditText

    val auth = FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance().getReference("userInfo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
        listeners()
    }
    private fun init(){
        mail = findViewById(R.id.registerMail)
        password = findViewById(R.id.registerPassword)
        registration = findViewById(R.id.registerButton)
        already = findViewById(R.id.alreadyHave)

        username = findViewById(R.id.registerUsername)
        dateOfBirth = findViewById(R.id.registerBirth)
        phone = findViewById(R.id.registerPhone)
        photoUrl = findViewById(R.id.registerProfilePhoto)
    }
    private fun listeners() {

        registration.setOnClickListener {

            val username1 = username.text.toString()
            val dateOfBirth1 = dateOfBirth.text.toString()
            val phone1 = phone.text.toString()
            val profilePhoto1 = photoUrl.text.toString()


            val mail1 = mail.text.toString()
            val password1 = password.text.toString()
            val userInfo2 = User2(username1, dateOfBirth1, phone1, profilePhoto1)


            if (mail1.isEmpty() || password1.isEmpty()){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail1, password1)


                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            db.child(auth.currentUser?.uid.toString()).setValue(userInfo2)
                            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        already.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}