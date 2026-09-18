package com.example.bibliotech.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.bibliotech.model.Libro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEditarLibro(
    libro: Libro,
    onGuardar: (Libro) -> Unit,
    onCancelar: () -> Unit
) {

}
