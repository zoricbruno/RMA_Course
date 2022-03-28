package hr.ferit.taskie.ui.task_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.taskie.R
import hr.ferit.taskie.model.Task

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    private val tasks = mutableListOf<Task>()
    var onTaskSelectedListener: OnTaskEventListener? = null

    fun setTasks(tasks: List<Task>) {
        this.tasks.clear()
        this.tasks.addAll(tasks)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.bind(task)
        onTaskSelectedListener?.let { listener ->
            holder.itemView.setOnClickListener { listener.onTaskSelected(task.id) }
            holder.itemView.setOnLongClickListener { listener.onTaskLongPress(task) }
        }
    }

    override fun getItemCount(): Int = tasks.count()
}

