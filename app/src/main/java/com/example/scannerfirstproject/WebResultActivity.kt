package com.example.scannerfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.scannerfirstproject.databinding.ActivityWebResultBinding

class WebResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebResultBinding
    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wbWebResults.webChromeClient = object: WebChromeClient() {

        }

        binding.wbWebResults.webViewClient = object: WebViewClient() {

        }

        val settings = binding.wbWebResults.settings
        settings.javaScriptEnabled = true

        binding.wbWebResults.loadUrl(getResults())
    }

    private fun getResults(): String {
        val bundle = intent.extras
        if (bundle != null) {
            url = bundle.getString("my_url").toString()
        }
        return url
    }

    override fun onBackPressed() {
        if(binding.wbWebResults.canGoBack()) {
            binding.wbWebResults.goBack()
        } else {
            super.onBackPressed()
        }
    }
}