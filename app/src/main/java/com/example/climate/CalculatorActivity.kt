package com.example.climate

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val etKm = findViewById<EditText>(R.id.etKm)
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalc.setOnClickListener {
            val km = etKm.text.toString().toFloatOrNull()
            if (km != null && km >= 0) {
                val emissions = km * 0.21f // average CO₂ per km
                tvResult.text = getString(R.string.result_format, emissions)
            } else {
                tvResult.text = getString(R.string.invalid_input)

            }
        }
    }
}
