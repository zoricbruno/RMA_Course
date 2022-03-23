package hr.ferit.taskie.di

import androidx.room.RoomDatabase
import hr.ferit.taskie.Taskie
import hr.ferit.taskie.data.memory_db.InMemoryDb
import hr.ferit.taskie.data.TaskDao
import hr.ferit.taskie.data.TaskRepository
import hr.ferit.taskie.data.TaskRepositoryImpl
import hr.ferit.taskie.data.room.TaskDatabase

object TaskRepositoryFactory {

    val roomDb = TaskDatabase.getDatabase(Taskie.application)
    val taskRepository: TaskRepository = TaskRepositoryImpl(roomDb.getTaskDao())
}