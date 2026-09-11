package com.example.bibliotech.model
/*
data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val categoria: String,
    val anio: Int,
    val descripcion:String,
    val disponible: Boolean
)*/
//Convertir la clase en una tabla de Room
import androidx.room.Entity
//Define la llave primaria de la tabla
import  androidx.room.PrimaryKey
//Ahora la clase representa a "libros en SQlite y ademas sirve de modelo para la UI
@Entity("Libros")
data class Libro(
    //Identificador unico generado automaticamente
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    //Resto de propiedades
    val titulo: String,
    val autor: String,
    val categoria: String,
    val anio: Int,
    val descripcion:String,
    val disponible: Boolean
)
