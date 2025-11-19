package pe.isil.todo.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.isil.todo.domain.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailView(
    modifier: Modifier = Modifier,
    task: Task?,
    onDelete: (Task) -> Unit,
    onSave: (Task) -> Unit
) {

    val title = remember {
        mutableStateOf(task?.title ?: "")
    }

    val description = remember {
        mutableStateOf(task?.description ?: "")
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {

            }, actions = {
                task?.let { task ->
                    IconButton(
                        onClick = {
                            onDelete(task)
                        }
                    ) {
                        Icon(Icons.Default.DeleteOutline, contentDescription = null)
                    }
                }

            })
        },
        floatingActionButton = {
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
                placeholder = {
                    Text("Title")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = title.value,
                onValueChange = { title.value = it })
            OutlinedTextField(
                placeholder = {
                    Text("Description")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = description.value,
                onValueChange = { description.value = it })
        }

    }
}