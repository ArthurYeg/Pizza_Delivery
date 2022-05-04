package com.example.fragment

import android.annotation.SuppressLint
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
import android.widget.Toast
import com.example.pizzadelivery.R
import java.util.Locale.getDefault

class SendMassegeFragment : Fragment() {
    lateinit var send: Button
    lateinit var phone: EditText
    lateinit var massege: EditText

    @SuppressLint("UnlocalizedSms")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_send_massege, container, false)


        phone = view.findViewById(R.id.phone_et)
        massege = view.findViewById(R.id.message_et)
        send = view.findViewById(R.id.send_btn)
        send.setOnClickListener {
            val phoneNumber=phone.text.toString()

                val smsIntent=Intent(Intent.ACTION_VIEW)
                smsIntent.data=Uri.parse("sms:89814660959")
                startActivity(smsIntent)
                Toast.makeText(getActivity(), "Сообщение отправлено", Toast.LENGTH_LONG).show()

            }




        return view
    }


}