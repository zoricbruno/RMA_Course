package hr.ferit.taskie.data

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.ferit.taskie.model.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM tasks WHERE id =:id")
    fun getTaskById(id: Long): Task?

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<Task>>
}

