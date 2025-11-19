package pe.isil.todo.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.isil.todo.domain.Task

@Composable
fun TaskDetailView(
    modifier: Modifier = Modifier,
    task: Task?,
    onSave: (Task) -> Unit
) {

    val title = remember {
        mutableStateOf(task?.title ?: "")
    }

    val description = remember {
        mutableStateOf(task?.description ?: "")
    }
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            val task =
                Task(
                    id = task?.id,
                    title = title.value,
                    description = description.value,
                    isCompleted = task?.isCompleted ?: false
                )
            onSave(task)
        }) {
            Icon(Icons.Default.Save, contentDescription = null)
        }
    }) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = title.value,
                onValueChange = { title.value = it })
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = description.value,
                onValueChange = { description.value = it })
        }

    }
}