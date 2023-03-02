package com.example.examenuwu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenuwu.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var titulosPeli = intent.getStringExtra("tituloPeli")
        var minutosPeli = intent.getIntExtra("minutosPeli", 0)


        binding.button2.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            if (binding.eTDirector.text.toString()
                    .isNotEmpty() && binding.eTAnoLanzamiento.text.toString()
                    .toInt() >= 0
            ) {
                var intent = Intent(this, MovieDisplayActivity::class.java)
                intent.putExtra(
                    "movie",
                    Movie(
                        titulosPeli!!,
                        minutosPeli,
                        binding.eTDirector.text.toString(),
                        binding.eTAnoLanzamiento.text.toString().toInt()
                    )
                )
                startActivity(intent)
            } else
                Toast.makeText(this, "Ingresa unos datos validos", Toast.LENGTH_SHORT).show()
        }
    }
}