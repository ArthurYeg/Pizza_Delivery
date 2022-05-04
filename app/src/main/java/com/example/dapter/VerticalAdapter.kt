package com.example.dapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzadelivery.PizzaItemV
import com.example.pizzadelivery.R

class VerticalAdapter(private val List: ArrayList<PizzaItemV>) :
    RecyclerView.Adapter<VerticalAdapter.CustomViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_vertical, parent, false)
        return CustomViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = List[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.titleText.text = currentItem.titleText
        holder.description.text = currentItem.description
        holder.price.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return List.size
    }

    class CustomViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ImageView = itemView.findViewById(R.id.titleImage)
        val titleText: TextView = itemView.findViewById(R.id.titleText)
        val description: TextView = itemView.findViewById(R.id.description)
        val price: TextView = itemView.findViewById(R.id.price)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)

            }

        }
    }
    }

