package com.example.laba

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class zaversheniye : AppCompatActivity() {
    private lateinit var rating_container: LinearLayout
    private lateinit var btn_predlozh_otsenku: Button
    private lateinit var btn_otpravka: Button
    private lateinit var perehod_osnovn_ekran: Button
    private lateinit var podpiska_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_zaversheniye)

        rating_container = findViewById(R.id.rating_container)
        btn_predlozh_otsenku = findViewById(R.id.predlozh_otsenku_button)
        btn_otpravka = findViewById(R.id.btn_otpravka)
        podpiska_button = findViewById(R.id.podpiska_button)

        rating_container.visibility = View.GONE
        btn_predlozh_otsenku.setOnClickListener {
            rating_container.visibility = View.VISIBLE
        }

        btn_otpravka.setOnClickListener {
            Toast.makeText(this, "Ты лучший!", Toast.LENGTH_SHORT).show()
        }

        perehod_osnovn_ekran.setOnClickListener {
            val intent = Intent(this, glavniy_ekran::class.java)
            startActivity(intent)
        }

    }
}
