package com.example.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.pizzadelivery.R


class ContactFragment : Fragment() {

    lateinit var map: Button
    lateinit var send: Button
    lateinit var call: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        map = view.findViewById(R.id.map_btn)
        map.setOnClickListener {
            val fr = MapsFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, fr)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        call = view.findViewById(R.id.call_tv)
        call.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "89114927342")
            startActivity(dialIntent)
            Toast.makeText(getActivity(), "Звонить", Toast.LENGTH_LONG).show()
        }

        send = view.findViewById(R.id.send_btn)
        send.setOnClickListener {
            val smsIntent = Intent(Intent.ACTION_VIEW)
            smsIntent.data = Uri.parse("sms:" + "89114927342")
            startActivity(smsIntent)
        }

        return view

    }

}

