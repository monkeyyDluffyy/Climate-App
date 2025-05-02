package com.example.climate

data class ForecastItem(
    val time: String,         // e.g., "10 am"
    val temperature: String,  // e.g., "16°C"
    val iconRes: Int          // Resource ID for weather icon (e.g., R.drawable.ic_cloudy)
)