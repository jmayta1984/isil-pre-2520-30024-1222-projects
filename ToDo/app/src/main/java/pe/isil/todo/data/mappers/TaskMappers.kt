package pe.isil.todo.data.mappers

import pe.isil.todo.data.local.TaskEntity
import pe.isil.todo.domain.Task

fun Task.toEntity(): TaskEntity =
    TaskEntity(
        id = this.id ?: 0,
        title = this.title,
        description = this.description,
        isCompleted = this.isCompleted
    )

fun TaskEntity.toDomain(): Task =
    Task(
        id = this.id,
        title = this.title,
        description = this.description,
        isCompleted = this.isCompleted

    )