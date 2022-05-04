package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.pizzadelivery.R

class MenuFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val contact = view.findViewById<View>(R.id.contact_btn) as Button
        val about = view.findViewById<View>(R.id.about_btn) as Button
        val basket = view.findViewById<View>(R.id.basket_btn) as Button
        val enter=view.findViewById<View>(R.id.enter_btn) as Button

        contact.setOnClickListener {
            val fm = ContactFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, fm)
            transaction.addToBackStack(null)
            transaction.commit()

        }
        about.setOnClickListener {
            val frg = AboutUsFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, frg)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        basket.setOnClickListener {
            val fmm = BasketFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, fmm)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        enter.setOnClickListener {
            val frag = EnterFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, frag)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }


}