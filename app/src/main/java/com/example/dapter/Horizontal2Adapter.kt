package com.example.dapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzadelivery.PizzaItemH2
import com.example.pizzadelivery.R

class Horizontal2Adapter(private val ItemList: ArrayList<PizzaItemH2>) :
    RecyclerView.Adapter<Horizontal2Adapter.ViewHolder>() {

    private lateinit var momListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        momListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_horizontal2, parent, false)
        return ViewHolder(view, momListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = ItemList[position]
        holder.itemTitle.text = currentItem.textTitle
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}