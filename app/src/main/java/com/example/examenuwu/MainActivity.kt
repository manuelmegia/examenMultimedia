package com.example.examenuwu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenuwu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.eTTitulo.text.toString().isNotEmpty() && binding.eTDuracion.text.toString()
                    .toInt() >= 0
            ) {
                var intent = Intent(this, MovieDetailsActivity::class.java)
                intent.putExtra("tituloPeli", binding.eTTitulo.text.toString())
                intent.putExtra("minutosPeli", binding.eTDuracion.text.toString().toInt())
                startActivity(intent)
            } else
                Toast.makeText(this, "Ingresa unos datos validos", Toast.LENGTH_SHORT).show()
        }
    }
}