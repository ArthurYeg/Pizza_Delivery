package com.example.dapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzadelivery.PizzaItemH
import com.example.pizzadelivery.R

class HorizontalAdapter(private val MyList: ArrayList<PizzaItemH>) :
    RecyclerView.Adapter<HorizontalAdapter.MyViewHolder>() {

    private lateinit var moListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        moListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_horizontal, parent, false)
        return MyViewHolder(view, moListener)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = MyList[position]
        holder.banner.setImageResource(currentItem.imageTitle)
    }

    override fun getItemCount(): Int {
        return MyList.size
    }
    class MyViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val banner: ImageView = itemView.findViewById(R.id.banner)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}


