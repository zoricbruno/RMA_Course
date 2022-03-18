package hr.ferit.taskie.di

import hr.ferit.taskie.data.memory_db.InMemoryDb
import hr.ferit.taskie.data.TaskDao
import hr.ferit.taskie.data.TaskRepository
import hr.ferit.taskie.data.TaskRepositoryImpl

object TaskRepositoryFactory {

    private val taskDao: TaskDao = InMemoryDb()
    val taskRepository: TaskRepository = TaskRepositoryImpl(taskDao)
}