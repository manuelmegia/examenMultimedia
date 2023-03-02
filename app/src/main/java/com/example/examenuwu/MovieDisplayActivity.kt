package com.example.examenuwu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenuwu.databinding.ActivityMovieDisplayBinding

class MovieDisplayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var titulosPeli = intent.getSerializableExtra("movie")
        if (titulosPeli != null)
            lista.add(titulosPeli as Movie)
        binding.verLista.text = lista.toString()

        binding.btnEliminar.setOnClickListener {
            if (checkByNombre(binding.nombreEliminar.text.toString()) != null) {
                lista.remove(checkByNombre(binding.nombreEliminar.text.toString()))
                Toast.makeText(this, "Pelicula eliminada con éxito", Toast.LENGTH_SHORT).show()
                binding.verLista.text = lista.toString()
            } else
                Toast.makeText(this, "No es posible eliminar la película", Toast.LENGTH_SHORT).show()
        }
        binding.btnFavorito.setOnClickListener {
            if (checkByNombre(binding.nombreFavorito.text.toString()) != null) {
                checkByNombre(binding.nombreFavorito.text.toString())?.let { it1 -> listaFav.add(it1) }
                Toast.makeText(this, "Exito", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "No es posible añadir la película", Toast.LENGTH_SHORT).show()
        }
        binding.btnAAdirPeli.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnVerFavoritas.setOnClickListener {
            var intent = Intent(this, FavoriteMoviesActivity::class.java)
            startActivity(intent)
        }
    }

    fun checkByNombre(check: String): Movie? {
        for (i in lista) {
            if (i.titulo == check)
                return i
        }
        return null
    }
}