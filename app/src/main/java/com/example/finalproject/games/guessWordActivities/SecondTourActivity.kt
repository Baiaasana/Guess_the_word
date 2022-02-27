package com.example.finalproject.games.guessWordActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.finalproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondTourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_tour)

        val navView2 = findViewById<BottomNavigationView>(R.id.bottomNavMenu2)

        val controller2 = findNavController(R.id.nav_host_fragment2)

        val appBarConfiguration2 = AppBarConfiguration(
            setOf(
                R.id.secondFirstFragment,
                R.id.secondSecondFragment
            )
        )
        setupActionBarWithNavController(controller2, appBarConfiguration2)
        navView2.setupWithNavController(controller2)
    }
}