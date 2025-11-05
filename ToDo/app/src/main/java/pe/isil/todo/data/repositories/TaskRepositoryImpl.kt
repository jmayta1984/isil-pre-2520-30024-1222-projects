package pe.isil.todo.data.repositories

import pe.isil.todo.data.local.TaskDao
import pe.isil.todo.data.mappers.toDomain
import pe.isil.todo.data.mappers.toEntity
import pe.isil.todo.domain.Task
import pe.isil.todo.domain.TaskRepository

class TaskRepositoryImpl (private val dao: TaskDao): TaskRepository {
    override suspend fun insert(task: Task) {
        dao.insert(task.toEntity())
    }

    override suspend fun delete(task: Task) {
        dao.delete(task.toEntity())
    }

    override suspend fun update(task: Task) {
        dao.update(task.toEntity())
    }

    override suspend fun getAll(): List<Task> {
        val entities = dao.fetchAll()
        return entities.map { it.toDomain() }
    }
}