package com.example.finalproject.games.tourFragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.User
import com.google.android.material.snackbar.Snackbar

class FirstSecondFragment: Fragment(R.layout.fragment_first_second) {

    private lateinit var FSWord: EditText
    private lateinit var FSExit: ImageView
    private lateinit var FSSubmit: Button

    val FSCorrectWord = "აზია"



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FSWord = view.findViewById(R.id.FSWord)
        FSExit = view.findViewById(R.id.FSImageExit)
        FSSubmit = view.findViewById(R.id.FSSubmit)

        FSExit.setOnClickListener {

            findNavController().navigate(R.id.action_firstSecondFragment_to_toursActivity)

        }

        FSSubmit.setOnClickListener {
            check()

            var user = User()
            user.point +=1

//            findNavController().navigate(FirstSecondFragmentDirections.actionFirstSecondFragmentToToursActivity(user.point.toString())


        }

    }

    private fun check() {
        if( FSWord.text.toString()== FSCorrectWord ){
            showErrorSnackBar("correct", false)
        }
        else{
            showErrorSnackBar("incorrect", true)

        }
    }

    fun showErrorSnackBar(message: String, errorMessage: Boolean) {


        val snackBar =
            Snackbar.make(activity?.findViewById(R.id.firstSecondFragment)!!, message, Snackbar.LENGTH_LONG)
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