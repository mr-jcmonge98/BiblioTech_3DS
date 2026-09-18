package com.example.bibliotech.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bibliotech.model.Libro


@Dao
interface LibroDao {

    //Funcion para insertar un libro CREATE
    @Insert
    fun insertarLibro(libro: Libro) : Long
//Funcion para traer libros READ
    @Query("SELECT * FROM libros")
    fun obtenerLibros(): List<Libro>

//Funcion para taer libro en base al ID "READ"
    @Query("SELECT * FROM libros WHERE id= :id")
    fun obtenerLibroPorId(id : Int): Libro?

    //Funcion para actualizar el libro
    @Update
    fun actualizarLibro(libro: Libro)
    //Funcion para eliminar un libto
    @Delete
    fun eliminarLibro(libro: Libro)
}
