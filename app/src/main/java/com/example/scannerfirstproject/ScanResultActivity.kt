package com.example.scannerfirstproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.scannerfirstproject.databinding.ActivityMainBinding

class ScanResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bScanner.text = getResults()

        binding.bScanner.setOnClickListener {
            val intent = Intent(this, WebResultActivity::class.java)
            intent.putExtra("my_url", getResults())
            startActivity(intent)
        }
    }

    private fun getResults(): String {
        val bundle = intent.extras
        if (bundle != null) {
            result = bundle.getString("my_results").toString()
        }
        return result
    }
}