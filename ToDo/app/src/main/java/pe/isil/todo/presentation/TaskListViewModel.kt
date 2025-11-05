package pe.isil.todo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.isil.todo.domain.Task
import pe.isil.todo.domain.TaskRepository

class TaskListViewModel(private val repository: TaskRepository): ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>>  = _tasks

    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.insert(task)
        }

    }

    fun deleteTask(){

    }

    fun updateTask() {

    }

    fun getAllTasks() {
        viewModelScope.launch {
           _tasks.value = repository.getAll()
        }
    }
}