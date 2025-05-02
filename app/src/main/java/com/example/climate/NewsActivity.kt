package com.example.climate

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class NewsActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @Suppress("SetJavaScriptEnabled")     // Trusting the source: climatechangenews.com
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()

        // Enable JavaScript if needed
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Load the climate change news site
        webView.loadUrl("https://www.climatechangenews.com/")

        // Handle back press using the new OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    finish() // Close activity if there's no back history
                }
            }
        })
    }
}
