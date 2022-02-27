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
import com.google.android.material.snackbar.Snackbar

class SecondSecondFragment: Fragment(R.layout.fragment_second_second) {

    private lateinit var SSWord: EditText
    private lateinit var SSExit: ImageView
    private lateinit var SSSubmit: Button
    val SSCorrectWord = "პორტი"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SSWord = view.findViewById(R.id.SSWord)
        SSExit = view.findViewById(R.id.SSImageExit)
        SSSubmit = view.findViewById(R.id.SSSubmit)

        SSExit.setOnClickListener {

            findNavController().navigate(R.id.action_secondSecondFragment_to_toursActivity2)

        }


    SSSubmit.setOnClickListener {
            check()

        }
    }
    private fun check () {

        if( SSWord.text.toString() == SSCorrectWord){
            showErrorSnackBar("correct", false)
        }
        else{
            showErrorSnackBar("incorrect", true)


        }
    }
    fun showErrorSnackBar(message: String, errorMessage: Boolean) {


        val snackBar =
            Snackbar.make(activity?.findViewById(R.id.secondSecondFragment)!!, message, Snackbar.LENGTH_LONG)
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