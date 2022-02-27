package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SettingsActivity : AppCompatActivity() {

    private lateinit var changePassword: TextView
    private lateinit var logOut: TextView
    private lateinit var changeImage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        changePassword = findViewById(R.id.settingsChangePassword)
        logOut = findViewById(R.id.settingsProfileLogOut)
        changeImage = findViewById(R.id.settingsChangePhoto)

        changeImage.setOnClickListener {

            startActivity(Intent(this, ChangePhotoActivity::class.java))
            finish()
        }

        changePassword.setOnClickListener {

            startActivity(Intent(this, ChangePasswordActivity::class.java))
            finish()
        }

        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}