package com.example.bibliotech.data

// *** IMPORTACIONES ***
import androidx.room.Database
import androidx.room.RoomDatabase
//importamos la entidad Libro
import com.example.bibliotech.model.Libro
//ESTA CLASE REPRESENTA LA BASE DE DATOS PRINCIPAL
@Database(
    //Lista de tablas que tendrá la base de dato
    entities = [Libro::class],
    //Primera version de la base de datos
    version = 1,
    exportSchema = false
)
abstract class BibliotecaDatabase : RoomDatabase(){
    //Aqui agregaremos las invocaciones de Data Access Objetc
    abstract fun libroDao() : LibroDao
}