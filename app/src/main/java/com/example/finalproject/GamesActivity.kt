package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.finalproject.games.guessWordActivities.PlayExitActivity
import com.example.finalproject.games.TicTacToeActivity

class GamesActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val tictac = findViewById<Button>(R.id.gamesTicTacToe)
        val guessWord = findViewById<Button>(R.id.gamesGuessWord)

        tictac.setOnClickListener {

            startActivity(Intent(this, TicTacToeActivity::class.java))
            finish()
        }

        guessWord.setOnClickListener {

            startActivity(Intent(this, PlayExitActivity::class.java))
            finish()
        }
    }
}