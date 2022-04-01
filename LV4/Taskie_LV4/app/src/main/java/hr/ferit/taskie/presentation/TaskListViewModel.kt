package hr.ferit.taskie.presentation

import androidx.lifecycle.ViewModel
import hr.ferit.taskie.data.repository.TaskRepository
import hr.ferit.taskie.model.Task

class TaskListViewModel(
    val taskRepository: TaskRepository
) : ViewModel() {
    val tasks = taskRepository.getAllTasks()

    fun delete(task: Task) {
        taskRepository.delete(task)
    }
}
