package com.dicoding.liriklagu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.liriklagu.R
import com.dicoding.liriklagu.data.Musik

class ListMusikAdapter(private val listMusik: ArrayList<Musik>) : RecyclerView.Adapter<ListMusikAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.rv_lirik)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMusik.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listMusik[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDeskripsi.text = description
    }
}
