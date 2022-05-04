package com.example.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pizzadelivery.MainActivity
import com.example.pizzadelivery.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider


class NumberFragment : Fragment() {

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {

    val view = inflater.inflate(R.layout.fragment_enter, container, false)
    val buttom=view.findViewById<View>(R.id.numbertel_btn) as Button
    buttom.setOnClickListener {
        val fmm = CodeNumberFragment()
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fmm)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    return view


}

}