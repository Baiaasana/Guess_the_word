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

class SecondFirstFragment: Fragment(R.layout.fragment_second_first) {

    private lateinit var SFWord: EditText
    private lateinit var SFExit: ImageView
    private lateinit var SFSubmit: Button
    val SFCorrectWord = "ფუნტი"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SFWord = view.findViewById(R.id.SFWord)
        SFExit = view.findViewById(R.id.SFImageExit)
        SFSubmit = view.findViewById(R.id.SFSubmit)

        SFExit.setOnClickListener {

            findNavController().navigate(R.id.action_secondFirstFragment_to_toursActivity2)

        }


    SFSubmit.setOnClickListener {
            check()

        }
    }
    private fun check () {

        if( SFWord.text.toString() == SFCorrectWord){
            showErrorSnackBar("correct", false)
        }
        else{
            showErrorSnackBar("incorrect", true)


        }
    }
    fun showErrorSnackBar(message: String, errorMessage: Boolean) {


        val snackBar =
            Snackbar.make(activity?.findViewById(R.id.secondFirstFragment)!!, message, Snackbar.LENGTH_LONG)
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