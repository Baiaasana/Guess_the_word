package com.example.finalproject.games.guessWordActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.finalproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ThirdTourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_tour)

        val navView3 = findViewById<BottomNavigationView>(R.id.bottomNavMenu3)

        val controller3 = findNavController(R.id.nav_host_fragment3)

        val appBarConfiguration3 = AppBarConfiguration(
            setOf(
                R.id.thirdFirstFragment,
                R.id.thirdSecondFragment
            )
        )
        setupActionBarWithNavController(controller3, appBarConfiguration3)
        navView3.setupWithNavController(controller3)
    }
}
