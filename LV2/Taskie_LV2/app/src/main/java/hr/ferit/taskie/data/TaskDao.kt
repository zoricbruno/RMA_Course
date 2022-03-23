package hr.ferit.taskie.data

import hr.ferit.taskie.data.model.Task


interface TaskDao {

    fun save(task: Task)
    fun delete(task: Task)
    fun getTaskById(id: Long): Task?
    fun getAllTasks(): List<Task>
}

