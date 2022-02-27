package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {

    private lateinit var settings: Button
    private lateinit var email: TextView
    private lateinit var image: ImageView
    private lateinit var profileUsername: TextView
    private lateinit var profileBirth: TextView
    private lateinit var profilePhone: TextView
    private lateinit var games: Button

    val auth = FirebaseAuth.getInstance()
    val db = FirebaseDatabase.getInstance().getReference("userInfo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        settings = findViewById(R.id.profileSettingsButton)
        email = findViewById(R.id.profileMail)
        image = findViewById(R.id.profilePhoto)
        profileUsername = findViewById(R.id.profileUsername)
        profileBirth = findViewById(R.id.profileBirth)
        profilePhone = findViewById(R.id.profilePhone)
        games = findViewById(R.id.profileGameButton)


        email?.text = FirebaseAuth.getInstance().currentUser?.email

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo = snapshot.getValue(User::class.java) ?: return

                Glide.with(this@ProfileActivity).load(userInfo.imageUrl).placeholder(R.drawable.profile_place_holder).into(image)

            }
            override fun onCancelled(error: DatabaseError) {
            }

        })

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo = snapshot.getValue(User2::class.java) ?: return

                Glide.with(this@ProfileActivity).load(userInfo.photoURL).placeholder(R.drawable.profile_place_holder).into(image)

            }
            override fun onCancelled(error: DatabaseError) {
            }

        })

        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo2 = snapshot.getValue(User2::class.java) ?: return

                profileUsername.text = userInfo2.username
                profileBirth.text = userInfo2.dateOfBirth
                profilePhone.text = userInfo2.phone


            }

            override fun onCancelled(error: DatabaseError) {
            }

        })


        settings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        games.setOnClickListener {
            startActivity(Intent(this, GamesActivity::class.java))
        }


    }
}