package hr.ferit.taskie.model

sealed class TaskPriority{
    object High : TaskPriority() {
        override fun toString(): String = "HIGH"
    }
    object Medium : TaskPriority() {
        override fun toString(): String = "MEDIUM"
    }
    object Low : TaskPriority(){
        override fun toString(): String = "LOW"
    }
}