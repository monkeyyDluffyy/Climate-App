package com.example.climate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class MapPagerAdapter(private val context: android.content.Context, private val items: List<MapData>) :
    RecyclerView.Adapter<MapPagerAdapter.MapViewHolder>() {

    class MapViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.mapImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_map_image, parent, false)
        return MapViewHolder(view)
    }

    override fun onBindViewHolder(holder: MapViewHolder, position: Int) {
        holder.image.setImageResource(items[position].imageRes)
    }

    override fun getItemCount(): Int = items.size
}
