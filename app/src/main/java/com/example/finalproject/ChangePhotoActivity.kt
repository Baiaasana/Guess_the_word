package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.FirebaseDatabaseKtxRegistrar
import java.time.temporal.ValueRange

class ChangePhotoActivity : AppCompatActivity() {

    lateinit var url: EditText
    lateinit var changePhotoButton: Button

    val auth = FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance().getReference("userInfo")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_photo)

        url = findViewById(R.id.changePhotoUrl)
        changePhotoButton = findViewById(R.id.changePhotoButton)



        changePhotoButton.setOnClickListener {

            val url1 = url.text.toString()
            db.child(auth.currentUser?.uid!!).child("photoUrl").setValue(url1)

//            val url1 = url.text.toString()
//            val userinfo = User(url1)
//            db.child(auth.currentUser?.uid!!).child("photoUrl").setValue(userinfo)

        }
    }
}