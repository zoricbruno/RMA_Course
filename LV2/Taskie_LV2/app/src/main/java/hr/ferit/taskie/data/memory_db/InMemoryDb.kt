package hr.ferit.taskie.data.memory_db

import hr.ferit.taskie.data.TaskDao
import hr.ferit.taskie.data.model.Task
import hr.ferit.taskie.data.model.TaskPriority
import kotlin.random.Random

class InMemoryDb : TaskDao {

    private val tasks = mutableListOf<Task>()

    init {
        val priorities =
            arrayOf(TaskPriority.High, TaskPriority.Medium, TaskPriority.Low)
        for (i in 1..30) {
            save(
                Task(
                    i.toLong(),
                    "Task_$i",
                    "Please, do task.",
                    priorities[Random.nextInt(3)])
            )
        }
    }

    override fun save(task: Task) {
        tasks.add(task)
    }

    override fun delete(task: Task) {
        tasks.remove(task)
    }

    override fun getTaskById(id: Long): Task? {
        return tasks.firstOrNull { it.id == id }
    }

    override fun getAllTasks(): List<Task> {
        return tasks
    }


}