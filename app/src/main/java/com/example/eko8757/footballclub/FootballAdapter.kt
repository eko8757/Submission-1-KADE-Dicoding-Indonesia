package com.example.eko8757.footballclub

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class FootballAdapter(private val context: Context, private val items : List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<FootballAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.football_list, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName:TextView? = view.findViewById(R.id.tvname)
        var imgClub:ImageView = view.findViewById(R.id.ivimage)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            tvName?.text = items.name
            Glide.with(itemView.context).load(items.image).into(imgClub)

            itemView.setOnClickListener {
                listener (items)
            }
        }
    }
}
