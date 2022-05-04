package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.pizzadelivery.R

class InfoFragment : Fragment() {
    //            bundle.let {  } read--> also, with, run

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val itemView = inflater.inflate(R.layout.fragment_info, container, false)
        val titleImageInfo: ImageView? = itemView.findViewById(R.id.titleImage)
        val titleTextInfo: TextView? = itemView.findViewById(R.id.titleText)
        val mainInfo: TextView? = itemView.findViewById(R.id.info)
        val infoTextInfo: TextView? = itemView.findViewById(R.id.infoText)

        val bundle:Bundle? = arguments
        val titleText = bundle?.getString("titleText")
        val titleImage = bundle?.getInt("titleImage")
        val info = bundle?.getString("info")
        val infoText = bundle?.getString("infoText")
        if (titleImage != null) {
            titleImageInfo?.setImageResource(titleImage)
        }
        titleTextInfo?.text = titleText
        mainInfo?.text = info
        infoTextInfo?.text = infoText


        val view = inflater.inflate(R.layout.fragment_info, container, false)
        val addToCart = view.findViewById<View>(R.id.addToCart) as Button
        addToCart.setOnClickListener {
            val fmm = BasketFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, fmm)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return itemView

    }
}