package com.example.climate

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MapsActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var mapTitle: TextView
    private lateinit var mapDescription: TextView

    private val maps = listOf(
        MapData("Heatwave Zones", R.drawable.map_heatwave, "Regions frequently impacted by heatwaves, especially northern and central India."),
        MapData("Greenhouse Gas Emission Hotspots", R.drawable.map_ghg, "Urban and industrial zones contributing to GHG emissions."),
        MapData("Air Quality Index (AQI)", R.drawable.map_aqi, "AQI levels across major cities, indicating pollution levels."),
        MapData("Agricultural Contribution", R.drawable.map_agriculture, "Regions with high agricultural output like Punjab and Haryana."),
        MapData("Water Availability per Capita", R.drawable.map_water, "States ranked by per capita water resources.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        viewPager = findViewById(R.id.viewPager)
        mapTitle = findViewById(R.id.textMapTitle)
        mapDescription = findViewById(R.id.textMapDescription)

        val adapter = MapPagerAdapter(this, maps)
        viewPager.adapter = adapter

        updateText(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateText(position)
            }
        })
    }

    private fun updateText(position: Int) {
        mapTitle.text = maps[position].title
        mapDescription.text = maps[position].description
    }
}
