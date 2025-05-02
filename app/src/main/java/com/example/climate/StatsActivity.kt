package com.example.climate

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.climate.ForecastAdapter
import com.example.climate.api.WeatherApi
import com.example.climate.api.WeatherResponse
import com.example.climate.ForecastItem
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*


class StatsActivity : AppCompatActivity() {

    private lateinit var textViewCity: TextView
    private lateinit var textViewTime: TextView
    private lateinit var textViewCondition: TextView
    private lateinit var textViewTempBig: TextView
    private lateinit var textViewMinMax: TextView
    private lateinit var textViewHumidity: TextView
    private lateinit var recyclerForecast: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        textViewCity = findViewById(R.id.textViewCity)
        textViewTime = findViewById(R.id.textViewTime)
        textViewCondition = findViewById(R.id.textViewCondition)
        textViewTempBig = findViewById(R.id.textViewTempBig)
        textViewMinMax = findViewById(R.id.textViewMinMax)
        recyclerForecast = findViewById(R.id.recyclerForecast)
        textViewHumidity = findViewById(R.id.textViewHumidity)

        textViewTime.text = SimpleDateFormat(getString(R.string.time_format), Locale.getDefault()).format(Date())


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherApi = retrofit.create(WeatherApi::class.java)
        val call = weatherApi.getWeather("Delhi", "88efa37a186a27ac55cb4c9f279b1276")

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weather = response.body()
                    val temp = weather?.main?.temp?.toInt() ?: 0
                    val minTemp = temp - 4
                    val maxTemp = temp + 6
                    val condition = weather?.weather?.get(0)?.main ?: getString(R.string.default_condition)
                    val humidity = weather?.main?.humidity ?: 0

                    textViewTempBig.text = getString(R.string.temperature_format, temp)
                    textViewCondition.text = condition
                    textViewMinMax.text = getString(R.string.min_max_format, maxTemp, minTemp)
                    textViewHumidity.text = getString(R.string.humidity_format, humidity)
                } else {
                    textViewCondition.text = getString(R.string.default_condition)
                }
            }


            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                textViewCondition.text = getString(R.string.error_message, t.message)

            }
        })

        // Forecast placeholder data
        val forecastItems = listOf(
            ForecastItem("10 AM", "22°C", R.drawable.ic_sunny),
            ForecastItem("1 PM", "26°C", R.drawable.ic_cloudy),
            ForecastItem("4 PM", "24°C", R.drawable.ic_rain),
            ForecastItem("7 PM", "21°C", R.drawable.ic_storm)
        )

        val forecastAdapter = ForecastAdapter(forecastItems)
        recyclerForecast.adapter = forecastAdapter
        recyclerForecast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}
