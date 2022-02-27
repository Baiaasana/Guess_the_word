package com.example.finalproject.games.guessWordActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.finalproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class FirstTourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_tour)

        val navView = findViewById<BottomNavigationView>(R.id.bottomNavMenu1)

        val controller = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.firstSecondFragment,
                R.id.firstSecondFragment
            )
        )
        setupActionBarWithNavController(controller, appBarConfiguration)
        navView.setupWithNavController(controller)
    }
}