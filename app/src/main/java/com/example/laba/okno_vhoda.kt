package com.example.laba

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.content.SharedPreferences
import android.widget.Toast
import org.json.JSONObject

class okno_vhoda : AppCompatActivity() {
    private lateinit var vhod_name: EditText
    private lateinit var vhod_password: EditText
    private lateinit var vhod_button: Button
    private lateinit var shared_preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okno_vhoda)

        vhod_name = findViewById(R.id.vhod_name)
        vhod_password = findViewById(R.id.vhod_password)
        vhod_button = findViewById(R.id.vhod_button)
        shared_preferences = getSharedPreferences("dannie_profilya", MODE_PRIVATE)

        vhod_button.setOnClickListener {
            val name = vhod_name.text.toString()
            val password = vhod_password.text.toString()

            val slovarJson = shared_preferences.getString("slovar_polzovateley", "{}")
            val slovar = JSONObject(slovarJson)

            if (slovar.has(name) && slovar.getString(name) == password) {
                Toast.makeText(this, "Вход выполнен успешно", Toast.LENGTH_SHORT).show()

                shared_preferences.edit().putString("EXTRA_NAME", name).putString("EXTRA_PASSWORD", password).apply()

                val intent = Intent(this, glavniy_ekran::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
