package hr.ferit.taskie.data

import androidx.lifecycle.LiveData
import hr.ferit.taskie.model.Task


interface TaskRepository {

    fun save(task: Task)
    fun delete(task: Task)
    fun getTaskById(id: Long): Task?
    fun getAllTasks(): LiveData<List<Task>>
}

