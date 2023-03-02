package com.example.examenuwu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FavoriteMoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_movies)
        var verFav = findViewById<TextView>(R.id.verLasFavorites)
        var btnVolver = findViewById<Button>(R.id.btnVolverAFavorites)

        verFav.text = listaFav.toString()

        btnVolver.setOnClickListener {
            var intent = Intent(this, MovieDisplayActivity::class.java)
            startActivity(intent)
        }
    }
}