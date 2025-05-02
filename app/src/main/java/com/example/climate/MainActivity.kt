package com.example.climate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardList = listOf(
            CardItem("Climate Stats", R.drawable.ic_stats, R.drawable.bg_stats),
            CardItem("Climate News", R.drawable.ic_news, R.drawable.bg_news),
            CardItem("Carbon Calculator", R.drawable.ic_calculator, R.drawable.bg_calculator),
            CardItem("Climate Tips", R.drawable.ic_tips, R.drawable.bg_tips),
            CardItem("Climate Maps", R.drawable.ic_maps, R.drawable.bg_maps),
            CardItem("Image Gallery", R.drawable.ic_gallery, R.drawable.bg_gallery)
        )


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CardAdapter(cardList) { item ->
            when (item.title) {
                "Climate Stats" -> startActivity(Intent(this, StatsActivity::class.java))
                "Climate News" -> startActivity(Intent(this, NewsActivity::class.java))
                "Carbon Calculator" -> startActivity(Intent(this, CalculatorActivity::class.java))
                "Climate Tips" -> startActivity(Intent(this, TipsActivity::class.java))
                "Climate Maps" -> startActivity(Intent(this, MapsActivity::class.java))
                "Image Gallery" -> startActivity(Intent(this, GalleryActivity::class.java))
            }
        }
        recyclerView.adapter = adapter

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
