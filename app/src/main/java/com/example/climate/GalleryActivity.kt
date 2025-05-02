package com.example.climate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryActivity : AppCompatActivity() {

    data class GalleryItem(
        val imageRes: Int,
        val titleResId: Int,
        val desc: String,
        val fact: String,
        val solution: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val recyclerView = findViewById<RecyclerView>(R.id.galleryRecyclerView)


        val galleryItems = listOf(
            GalleryItem(R.drawable.meltingglacier, R.string.melting_glaciers,
                "Glaciers are retreating due to rising temperatures.",
                "Glaciers lost 267 billion tons of ice/year (2000–2019).",
                "Reduce emissions and shift to renewable energy."),

            GalleryItem(R.drawable.wildfire, R.string.wildfires,
                "Global warming increases wildfire severity.",
                "2020 California fires released more CO₂ than power sector.",
                "Use forest management, climate action, and detection."),

            GalleryItem(R.drawable.deforestation, R.string.deforestation,
                "Forests are being cleared at an alarming rate.",
                "Forests absorb 2.6 billion tons of CO₂ per year.",
                "Promote reforestation and sustainable agriculture."),

            GalleryItem(R.drawable.pollution, R.string.pollution,
                "Factories and vehicles emit harmful gases.",
                "Top 100 companies responsible for 70% of emissions.",
                "Stronger environmental laws and clean tech are key."),

            GalleryItem(R.drawable.flood, R.string.floods,
                "Floods are more frequent due to rising seas and rains.",
                "1 billion people could be displaced by 2050 due to flooding.",
                "Improve urban planning and flood defenses."),

            GalleryItem(R.drawable.drought, R.string.droughts,
                "Lack of rain affects water access and crops.",
                "2.3 billion people live in water-stressed areas.",
                "Adopt water conservation and smart irrigation."),

            GalleryItem(R.drawable.polarbear, R.string.arctic_habitat,
                "Melting ice affects polar bears and marine life.",
                "Arctic is warming 4x faster than rest of Earth.",
                "Protect Arctic zones and enforce global climate pledges."),

            GalleryItem(R.drawable.renewableenergy, R.string.clean_energy,
                "Green energy is key to stopping climate change.",
                "Renewables provided 30% of global electricity in 2023.",
                "Invest in solar, wind, and hydro technologies.")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GalleryAdapter(galleryItems)


    }
}
