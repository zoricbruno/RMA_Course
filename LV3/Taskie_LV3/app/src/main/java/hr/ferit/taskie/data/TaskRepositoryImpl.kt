package hr.ferit.taskie.data

import hr.ferit.taskie.model.Task

class TaskRepositoryImpl(val taskDao: TaskDao) : TaskRepository {
    override fun save(task: Task) = taskDao.save(task)
    override fun delete(task: Task) = taskDao.delete(task)
    override fun getTaskById(id: Long): Task? = taskDao.getTaskById(id)
    override fun getAllTasks(): List<Task> = taskDao.getAllTasks()
}