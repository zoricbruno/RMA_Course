package hr.ferit.taskie.ui.task_list

import hr.ferit.taskie.model.Task

interface OnTaskEventListener{
    fun onTaskSelected(id: Long?)
    fun onTaskLongPress(task: Task?): Boolean
}