package com.example.finalproject.games.guessWordActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.finalproject.GamesActivity
import com.example.finalproject.R
import pl.droidsonroids.gif.GifImageView

class YouWonActivity : AppCompatActivity() {

    private lateinit var youWonExit: GifImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_you_win)

        youWonExit = findViewById(R.id.exitGif)

        youWonExit.setOnClickListener {

            startActivity(Intent(this, GamesActivity::class.java))

        }
    }
}