package hr.ferit.taskie.data.model

sealed class TaskPriority{
    object High : TaskPriority()
    object Medium : TaskPriority()
    object Low : TaskPriority()
}

data class Task(
    var id: Long? = null,
    val title: String,
    val content: String,
    val priority: TaskPriority
) {

}