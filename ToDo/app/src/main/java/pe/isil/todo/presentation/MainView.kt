package pe.isil.todo.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainView() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "task_list") {

        composable("task_list") {
            TaskListView {
                navController.navigate("task_detail")
            }
        }

        composable ("task_detail") {
            TaskDetailView()
        }
    }
}