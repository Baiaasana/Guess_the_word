package com.example.finalproject.games.guessWordActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.finalproject.R
import com.example.finalproject.User

class ToursActivity : AppCompatActivity() {

    private lateinit var firstTour: ImageView
    private lateinit var secondTour: ImageView
    private lateinit var thirdTour: ImageView
    private lateinit var toursExit: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tours)

        firstTour = findViewById(R.id.toursImage1)
        secondTour = findViewById(R.id.toursImage2)
        thirdTour = findViewById(R.id.toursImage3)
        toursExit = findViewById(R.id.toursImageExit)

//        val user = User()
//        if(user.point==0){
//            secondTour.isEnabled = false
//        }
//        if(user.point <= 4){
//            thirdTour.isEnabled = false
//        }



        firstTour.setOnClickListener{

            startActivity(Intent(this, FirstTourActivity::class.java ))
        }
        secondTour.setOnClickListener{

            startActivity(Intent(this, SecondTourActivity::class.java ))
        }
        thirdTour.setOnClickListener{

            startActivity(Intent(this, ThirdTourActivity::class.java ))
        }
        toursExit.setOnClickListener{

            startActivity(Intent(this, PlayExitActivity::class.java ))
        }


    }
}