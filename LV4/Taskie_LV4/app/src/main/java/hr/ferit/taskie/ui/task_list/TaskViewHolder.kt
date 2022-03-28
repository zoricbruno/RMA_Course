package hr.ferit.taskie.ui.task_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ferit.taskie.getColorResource
import hr.ferit.taskie.databinding.ItemTaskBinding
import hr.ferit.taskie.model.Task

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(task: Task) {
        val binding = ItemTaskBinding.bind(itemView)
        binding.itemTaskTitle.text = task.title
        binding.itemTaskContent.text = task.content
        binding.itemTaskPriority.setBackgroundResource(
            binding.itemTaskPriority.context.resources.getColorResource(task.priority)
        )
    }
}