package hr.ferit.taskie.ui.task_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.ferit.taskie.data.TaskRepository
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