package hr.ferit.taskie.presentation

import androidx.lifecycle.ViewModel
import hr.ferit.taskie.data.repository.TaskRepository
import hr.ferit.taskie.model.Task

class TaskDetailsViewModel(
    val taskRepository: TaskRepository
) : ViewModel() {

    fun getTaskById(id: Long?): Task? {
        var task: Task? = null
        id?.let { task = taskRepository.getTaskById(id) }
        return task
    }
}