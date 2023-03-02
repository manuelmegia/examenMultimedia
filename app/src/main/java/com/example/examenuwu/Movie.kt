package com.example.examenuwu

class Movie(var titulo: String, var duracion: Int, var director: String, var añoLanzamiento: Int) :
    java.io.Serializable {
    override fun toString(): String {
        return "Movie(titulo='$titulo', duracion=$duracion, director='$director', añoLanzamiento=$añoLanzamiento)"
    }
}