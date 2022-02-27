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

class ThirdFirstFragment:Fragment(R.layout.fragment_third_first) {

    private lateinit var TFWord: EditText
    private lateinit var TFExit: ImageView
    private lateinit var TFSubmit: Button
    val TFCorrectWord = "იტალია"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TFWord = view.findViewById(R.id.TFWord)
        TFExit = view.findViewById(R.id.TFImageExit)
        TFSubmit = view.findViewById(R.id.TFSubmit)

        TFExit.setOnClickListener {

            findNavController().navigate(R.id.action_thirdFirstFragment_to_toursActivity3)

        }


    TFSubmit.setOnClickListener {
            check()

        }
    }
    private fun check () {

        if( TFWord.text.toString() == TFCorrectWord){
            showErrorSnackBar("correct", false)
        }
        else{
            showErrorSnackBar("incorrect", true)


        }
    }
    fun showErrorSnackBar(message: String, errorMessage: Boolean) {


        val snackBar =
            Snackbar.make(activity?.findViewById(R.id.thirdFirstFragment)!!, message, Snackbar.LENGTH_LONG)
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