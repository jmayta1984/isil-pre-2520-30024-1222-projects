package pe.isil.todo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pe.isil.todo.domain.Task

@Composable
fun TaskListView(
    modifier: Modifier = Modifier,
    tasks: List<Task>,
    onTaskSelected: (Task) -> Unit,
    onToggleCompleted: (Task) -> Unit,
    onAdd: () -> Unit
) {

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
                Card(
                    onClick = {
                        onTaskSelected(task)
                    },
                    modifier = Modifier.padding(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(task.title, fontWeight = FontWeight.Bold)
                            Text(task.description)
                        }
                        Switch(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            checked = task.isCompleted, onCheckedChange = {
                                onToggleCompleted(task)
                            }
                        )
                    }
                }
            }
        }
    }

}