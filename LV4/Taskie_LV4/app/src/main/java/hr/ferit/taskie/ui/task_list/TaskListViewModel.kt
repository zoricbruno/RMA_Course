package hr.ferit.taskie.ui.task_list

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hr.ferit.taskie.data.TaskRepository
import hr.ferit.taskie.di.repositoryModule
import hr.ferit.taskie.model.Task

class TaskListViewModel(
    val taskRepository: TaskRepository
) : ViewModel() {
    val tasks = taskRepository.getAllTasks()

    fun delete(task: Task) {
        taskRepository.delete(task)
    }
}
