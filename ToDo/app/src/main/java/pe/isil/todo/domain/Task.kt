package pe.isil.todo.domain

data class Task(
    val id: Int? = null,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)
