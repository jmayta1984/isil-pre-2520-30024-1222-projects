package pe.isil.todo.di

import androidx.room.Room
import pe.isil.todo.MyApplication
import pe.isil.todo.data.local.AppDatabase
import pe.isil.todo.data.local.TaskDao
import pe.isil.todo.data.repositories.TaskRepositoryImpl
import pe.isil.todo.domain.TaskRepository
import pe.isil.todo.presentation.TaskListViewModel

object Module {

    fun getTaskListViewModel(): TaskListViewModel{
        return TaskListViewModel(getTaskRepository())
    }

    fun getTaskRepository() : TaskRepository = TaskRepositoryImpl(getTaskDao())

    fun getTaskDao(): TaskDao {
        return getAppDatabase().taskDao()
    }

    fun getAppDatabase(): AppDatabase {
       return Room.databaseBuilder(
            MyApplication.INSTANCE.applicationContext,AppDatabase::class.java, "todo").build()
    }
}

