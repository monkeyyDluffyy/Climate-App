package com.example.climate.api

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather> // <-- Add this to get condition
)

data class Main(
    val temp: Float,
    val humidity: Int
)

data class Weather(
    val main: String,         // e.g., "Clouds"
    val description: String   // e.g., "scattered clouds"
)
