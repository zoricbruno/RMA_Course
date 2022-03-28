package hr.ferit.taskie.ui.task_new

import androidx.lifecycle.ViewModel
import hr.ferit.taskie.data.TaskRepository
import hr.ferit.taskie.model.Task
import hr.ferit.taskie.model.TaskPriority
import java.util.*

class TaskNewViewModel(
    val taskRepository: TaskRepository
) : ViewModel() {
    fun save(title: String, contents: String, priority: TaskPriority, dateAdded: Date) {
        taskRepository.save(Task(0, title, contents, priority, dateAdded))
    }
}