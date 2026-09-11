package com.example.bibliotech.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bibliotech.viewmodel.LibroViewModel

@Composable
fun PantallaAgregarLibro(
    viewModel: LibroViewModel,
    onGuardar: () -> Unit,
    onCancelar: () -> Unit
){
    var titulo by remember {mutableStateOf("") }
    var autor by remember {mutableStateOf("") }
    var categoria by remember {mutableStateOf("") }
    var anio by remember {mutableStateOf("") }
    var descripcion by remember {mutableStateOf("") }
    var disponible by remember {mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)){
        Text("Agregar nuevo libro")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = {titulo = it},
            label = {Text("Título")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = autor,
            onValueChange = {autor = it},
            label = {Text("Autor")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = categoria,
            onValueChange = {categoria = it},
            label = {Text("Categoria")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = anio,
            onValueChange = {anio = it},
            label = {Text("Año de publicación")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

    }

}