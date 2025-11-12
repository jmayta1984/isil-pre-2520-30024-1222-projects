package pe.isil.todo.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun TaskDetailView(modifier: Modifier = Modifier) {

    val title = remember {
        mutableStateOf("")
    }

    val description = remember {
        mutableStateOf("")
    }
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Default.Save, contentDescription = null)
        }
    }) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            OutlinedTextField(value = title.value, onValueChange = {})
            OutlinedTextField(value = description.value, onValueChange = {})
        }

    }
}