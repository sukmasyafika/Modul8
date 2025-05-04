package com.example.modul8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val context: Context,
    private val images: List<DataModel>,
    val listener: (DataModel) -> Unit
) : RecyclerView.Adapter<ImageAdapter.ItemHolder>() {

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icons: ImageView = itemView.findViewById(R.id.icons_image)
        val title: TextView = itemView.findViewById(R.id.title_image)

        fun bindView(image: DataModel, listener: (DataModel) -> Unit) {
            icons.setImageResource(image.icons)
            title.text = image.title
            itemView.setOnClickListener { listener(image) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_layout_list_item, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindView(images[position], listener)
    }
}
