package hr.ferit.taskie.data

import hr.ferit.taskie.data.TaskDao
import hr.ferit.taskie.data.TaskRepository
import hr.ferit.taskie.data.model.Task
import hr.ferit.taskie.data.model.TaskPriority
import kotlin.random.Random

class TaskRepositoryImpl(val taskDao: TaskDao) : TaskRepository {
    override fun save(task: Task) = taskDao.save(task)
    override fun delete(task: Task) = taskDao.delete(task)
    override fun getTaskById(id: Long): Task? = taskDao.getTaskById(id)
    override fun getAllTasks(): List<Task> = taskDao.getAllTasks()
}