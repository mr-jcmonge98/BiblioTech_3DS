package com.example.bibliotech.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bibliotech.model.Libro

@Composable
fun PantallaDetalleLibro(
    libro: Libro,
    onRegresar: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(20.dp)){
        Icon(
            imageVector = Icons.AutoMirrored.Filled.MenuBook,
            contentDescription = "Libro",
            modifier = Modifier.height(30.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = libro.titulo,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Autor: ${libro.autor}")
        Text("Categoria: ${libro.categoria}")
        Text("Año: ${libro.anio}")
        Text("Descripcion: ${libro.descripcion}")
        Text("Disponible: ${libro.disponible}")

        Button(onClick=onRegresar) {
            Text("Regresar")
        }
    }
}
