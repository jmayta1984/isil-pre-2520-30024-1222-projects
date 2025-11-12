package pe.isil.todo.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.todo.di.Module.getTaskListViewModel
import pe.isil.todo.domain.Task

@Composable
fun MainView() {
    val navController = rememberNavController()
    val viewModel = getTaskListViewModel()
    val tasks = viewModel.tasks.collectAsState()

    val selectedTask = remember {
        mutableStateOf<Task?>(null)
    }
    NavHost(navController, startDestination = "task_list") {

        composable("task_list") {
            TaskListView(tasks = tasks.value,

                onTaskSelected = {
                    selectedTask.value = it
                    navController.navigate("task_detail")
                },
                onToggleCompleted = {
                viewModel.onToggleCompleted(it)
            } ) {
                selectedTask.value = null
                navController.navigate("task_detail")
            }
        }

        composable ("task_detail") {
            TaskDetailView(task = selectedTask.value) { task ->
                viewModel.addTask(task)
                navController.popBackStack()
            }
        }
    }
}