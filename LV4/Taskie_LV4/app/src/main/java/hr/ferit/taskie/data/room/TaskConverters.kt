package hr.ferit.taskie.data.room

import androidx.room.TypeConverter
import hr.ferit.taskie.model.TaskPriority
import java.util.*

class TaskConverters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toString(priority: TaskPriority): String{
        return priority.toString()
    }

    @TypeConverter
    fun fromString(priority: String): TaskPriority{
        return when(priority){
            TaskPriority.High.toString() -> TaskPriority.High
            TaskPriority.Medium.toString() -> TaskPriority.Medium
            TaskPriority.Low.toString() -> TaskPriority.Low
            else -> TaskPriority.Low
        }
    }
}