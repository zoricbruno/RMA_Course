package hr.ferit.taskie.ui.task_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ferit.taskie.getColorResource
import hr.ferit.taskie.R
import hr.ferit.taskie.model.Task
import hr.ferit.taskie.databinding.FragmentTaskDetailsBinding
import hr.ferit.taskie.presentation.TaskDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat

class TaskDetailsFragment : Fragment() {

    private val dateDisplayFormat = SimpleDateFormat("yyyy-MM-dd")
    private lateinit var binding: FragmentTaskDetailsBinding
    private val viewModel: TaskDetailsViewModel by viewModel()
    private val args: TaskDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val task = viewModel.getTaskById(args.taskId)
        display(task)
    }

    private fun display(task: Task?) {
        task?.let {
            binding.apply {
                tvTaskDateAdded.text = dateDisplayFormat.format(it.dateAdded)
                clTaskDetailsRoot.setBackgroundResource(resources.getColorResource(task.priority))
                tvTaskDetailsTitle.text = task.title
                tvTaskDetailsContents.text = task.content
                return
            }
        }
        binding.tvTaskDetailsTitle.text = getString(R.string.label_no_such_task)
    }

    companion object {
        val Tag = "TasksDetails"
        val TaskIdKey = "TaskId"

        fun create(id: Long): Fragment {
            val fragment = TaskDetailsFragment()
            return fragment
        }
    }
}