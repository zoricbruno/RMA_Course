package com.ferit.taskie

import android.content.res.Resources
import hr.ferit.taskie.R
import hr.ferit.taskie.model.TaskPriority

fun Resources.getColorResource(priority: TaskPriority): Int{
    return when(priority){
        TaskPriority.High -> R.color.red
        TaskPriority.Medium -> R.color.yellow
        else -> R.color.green
    }
}

