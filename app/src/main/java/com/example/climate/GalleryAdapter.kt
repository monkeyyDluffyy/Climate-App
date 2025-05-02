package com.example.climate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(private val items: List<GalleryActivity.GalleryItem>) :
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.galleryImage)
        val titleView: TextView = view.findViewById(R.id.galleryTitle)
        val descView: TextView = view.findViewById(R.id.galleryDesc)
        val factView: TextView = view.findViewById(R.id.galleryFact)
        val solutionView: TextView = view.findViewById(R.id.gallerySolution)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(context, item.imageRes))
        holder.titleView.text = context.getString(item.titleResId)
        holder.descView.text = item.desc
        holder.factView.text = context.getString(R.string.fact_text, item.fact)
        holder.solutionView.text = context.getString(R.string.solution_text, item.solution)
    }

    override fun getItemCount(): Int = items.size
}
