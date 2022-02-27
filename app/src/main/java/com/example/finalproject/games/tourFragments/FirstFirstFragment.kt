package com.example.finalproject.games.tourFragments


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.google.android.material.snackbar.Snackbar

class FirstFirstFragment: Fragment(R.layout.fragment_first_first) {

    private lateinit var FFWord: EditText
    private lateinit var FFExit: ImageView
    private lateinit var FFSubmit: Button


    val FFCorrectWord = "ჯუჯა"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FFWord = view.findViewById(R.id.FFWord)
        FFExit = view.findViewById(R.id.FFImageExit)
        FFSubmit = view.findViewById(R.id.FFSubmit)

        FFExit.setOnClickListener {

            findNavController().navigate(R.id.action_firstFirstFragment_to_toursActivity)

        }



        FFSubmit.setOnClickListener {
            check()

        }
    }
    private fun check () {

        if( FFWord.text.toString() == FFCorrectWord){
            showErrorSnackBar("correct", false)
        }
        else{
            showErrorSnackBar("incorrect", true)


        }
    }
    fun showErrorSnackBar(message: String, errorMessage: Boolean) {


        val snackBar =
            Snackbar.make(activity?.findViewById(R.id.firstFirstFragment)!!, message, Snackbar.LENGTH_LONG)
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