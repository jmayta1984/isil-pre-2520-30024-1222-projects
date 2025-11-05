package pe.isil.todo.domain

interface TaskRepository {
    suspend fun insert(task: Task)
    suspend fun delete(task: Task)
    suspend fun update(task: Task)
    suspend fun  getAll(): List<Task>
}