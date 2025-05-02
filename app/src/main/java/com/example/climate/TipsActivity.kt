package com.example.climate

import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class TipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        val tipsLayout = findViewById<LinearLayout>(R.id.tipsLayout)

        val tipsList = listOf(
            "🚿 Turn off the tap while brushing your teeth to save water.",
            "🚴‍♂️ Use a bicycle or walk for short distances.",
            "🛍️ Carry a reusable bag to avoid plastic.",
            "💡 Turn off lights when not in use.",
            "🌳 Plant a tree and care for it.",
            "🍃 Avoid fast fashion. Reuse clothes.",
            "🌱 Choose local and organic food.",
            "♻️ Recycle paper, plastic, glass, and electronics.",
            "🌞 Use solar-powered appliances when possible.",
            "📢 Educate others about climate change."
        )

        tipsList.forEach { tip ->
            val card = CardView(this).apply {
                radius = 16f
                cardElevation = 8f
                useCompatPadding = true
                setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
                layoutParams = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 12, 0, 12)
                }
            }

            val tipView = TextView(this).apply {
                text = tip
                textSize = 18f
                setPadding(24, 24, 24, 24)
                setTextColor(ContextCompat.getColor(this@TipsActivity, android.R.color.black))
            }

            card.addView(tipView)
            tipsLayout.addView(card)
        }
    }
}
