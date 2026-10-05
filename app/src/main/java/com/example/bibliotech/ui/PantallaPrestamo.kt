package com.example.bibliotech.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bibliotech.viewmodel.PrestamoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrestamo(
    onRegresar: () -> Unit,
    onPrestamoGuardado:() -> Unit,
    viewModel: PrestamoViewModel = viewModel()
) {
    // Datos a utilizar
    val estudiantes by viewModel.estudiantesActivos.collectAsState()
    val libros by viewModel.librosDisponibles.collectAsState()
    val prestamoGuardado by viewModel.prestamoGuardado.collectAsState()

    // Guardaremos los estados de los menus plegables
    var estudianteMenuAbierto by remember { mutableStateOf(false) }
    var libroMenuAbierto by remember { mutableStateOf(false) }

    // variables para guardar los elementos seleccionados de lso menu
    var estudianteSeleccionadoId by remember {
        mutableStateOf<Int?>(null)
    }
    var libroSeleccionadoId by remember {
        mutableStateOf<Int?>(null)
    }
    // Cargamos los datos al entrar a la pantalla
    LaunchedEffect(Unit) {
        viewModel.cargarDatos()
    }
    // Cuando se guarde el prestamo
    LaunchedEffect(prestamoGuardado) {
        if (prestamoGuardado) {
            viewModel.reiniciarEstadoGuardado()
            onPrestamoGuardado()
        }
    }
    // Construimos la interfaz
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Registrar Préstamo")
                },
                navigationIcon = {
                    IconButton(onClick = onRegresar) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier.padding(16.dp)
                .padding(paddingValues).fillMaxWidth()
        ) {
            // ---- MENU PARA SELECCIONAR EL ESTUDIANTE
            Text(text = "Estudiante:")
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(
                onClick = { estudianteMenuAbierto = true },
                modifier = Modifier.fillMaxWidth()
            ){
                val estudianteSeleccionado = estudiantes.find(
                    { it.id == estudianteSeleccionadoId }
                )
                Text(
                    text =
                        if(estudianteSeleccionado != null) {
                            "${estudianteSeleccionado.nombres}"+
                                    "${estudianteSeleccionado.apellidos}"+
                                "( ${estudianteSeleccionado.carnet})"
                        }else{"Seleccior estudiante"}
                )
                }
            // ----- menu desplegable de estudiantes-----
            DropdownMenu(
                expanded = estudianteMenuAbierto,
                onDismissRequest = {estudianteMenuAbierto = false},
                modifier = Modifier.fillMaxWidth()
            ) {
                estudiantes.forEach { estudiante ->
                    DropdownMenuItem(
                        text = {
                            Text(text = "${estudiante.nombres} " +
                                    "${estudiante.apellidos} -" +
                                    " ${estudiante.carnet}")
                        }, onClick = {estudianteSeleccionadoId =
                            estudiante.id
                            estudianteMenuAbierto = false}
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            // ---- MENU PARA SELECCIONAR EL LIBRO
            Text(text = "Libro:")
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(
                onClick = { libroMenuAbierto = true },
                modifier = Modifier.fillMaxWidth()
            ){
                val libroSeleccionado = libros.find(
                    { it.id == libroSeleccionadoId }
                )
                Text(
                    text =
                        if(libroSeleccionado != null) {
                            "${libroSeleccionado.titulo}"
                        }else{"Seleccione libro"}
                )
            }
            // ----- menu desplegable de libros-----
            DropdownMenu(
                expanded = libroMenuAbierto,
                onDismissRequest = {libroMenuAbierto = false},
                modifier = Modifier.fillMaxWidth()
            ) {
                libros.forEach { libro ->
                    DropdownMenuItem(
                        text = {
                            Text(text = "${libro.titulo} " +
                                    "${libro.autor}")
                        }, onClick = {libroSeleccionadoId =
                            libro.id
                            libroMenuAbierto = false}
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            // Boton de registrar prestamo
            Button(
                onClick = {
                    val estudianteId = estudianteSeleccionadoId
                    val libroId = libroSeleccionadoId
                    if (estudianteId != null && libroId != null) {
                        viewModel.registrarPrestamo(
                            libroId = libroId,
                            estudianteId = estudianteId
                        )
                    }
                },
                enabled = estudianteSeleccionadoId != null &&
                        libroSeleccionadoId != null,
                modifier = Modifier.fillMaxWidth()
            ){ Text(text = "Registrar Préstamo")}
        }
    }
}








    /*
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = "Registrar préstamo",
            fontSize = 24.sp
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Aquí se registrarán los préstamos."
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = onRegresar
        ) {
            Text("Regresar")
        }
    }*/

