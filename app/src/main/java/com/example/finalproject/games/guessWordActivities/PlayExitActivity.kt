package com.example.finalproject.games.guessWordActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.finalproject.GamesActivity
import com.example.finalproject.R

class PlayExitActivity : AppCompatActivity() {

    private lateinit var play: TextView
    private lateinit var exit: TextView
    private lateinit var sound: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_exit)

        play = findViewById(R.id.playExitPlay)
        exit = findViewById(R.id.PlayExitExit)
        sound = findViewById(R.id.PlayExitSound)

        play.setOnClickListener {
            startActivity(Intent(this, ToursActivity::class.java))
            finish()
        }
        exit.setOnClickListener {
            startActivity(Intent(this, GamesActivity::class.java))
            finish()
        }
    }
}