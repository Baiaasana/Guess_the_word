package com.example.finalproject.games.tourFragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.games.guessWordActivities.ToursActivity
import com.google.android.material.snackbar.Snackbar

class ThirdSecondFragment: Fragment(R.layout.fragment_third_second) {

    private lateinit var TSWord: EditText
    private lateinit var TSExit: ImageView
    private lateinit var TSSubmit: Button

    val TSCorrectWord = "ვეზუვი"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TSWord = view.findViewById(R.id.TSWord)
        TSExit = view.findViewById(R.id.TSImageExit)
        TSSubmit = view.findViewById(R.id.TSSubmit)

        TSExit.setOnClickListener {

            findNavController().navigate(R.id.action_thirdSecondFragment_to_toursActivity3)

        }

        TSSubmit.setOnClickListener {

            check()

            findNavController().navigate(R.id.action_thirdSecondFragment_to_youWinActivity)

        }

    }

    private fun check () {

        if( TSWord.text.toString() == TSCorrectWord){
            showErrorSnackBar("correct", false)
        }
        else{
            showErrorSnackBar("incorrect", true)


        }
    }
    fun showErrorSnackBar(message: String, errorMessage: Boolean) {


        val snackBar =
            Snackbar.make(activity?.findViewById(R.id.thirdSecondFragment)!!, message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        if (errorMessage) {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.colorSnackBarError
                )
            )
        } else {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.colorSnackBarSuccess
                )
            )
        }
        snackBar.show()
    }
}