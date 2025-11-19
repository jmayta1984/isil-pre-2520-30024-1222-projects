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
            getAllTasks()
        }

    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.update(task)
            getAllTasks()
        }
    }

    fun onToggleCompleted(task: Task) {
        val updateTask = task.copy(isCompleted = !task.isCompleted)
        viewModelScope.launch {
            repository.update(updateTask)
            getAllTasks()
        }
    }

    fun getAllTasks() {
        viewModelScope.launch {
           _tasks.value = repository.getAll()
        }
    }

    init {
        getAllTasks()
    }
}