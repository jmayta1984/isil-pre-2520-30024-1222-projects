package pe.isil.todo.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import pe.isil.todo.di.Module.getTaskListViewModel
import pe.isil.todo.domain.Task

@Composable
fun TaskListView(
    modifier: Modifier = Modifier,
    viewModel: TaskListViewModel = getTaskListViewModel(),
    onAdd: () -> Unit
) {

    val tasks by viewModel.tasks.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAdd) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier.padding(paddingValues)) {
            items(tasks) { task ->
                Text(task.title)
            }
        }
    }

}