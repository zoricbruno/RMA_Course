package hr.ferit.taskie.ui.task_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.taskie.databinding.FragmentTaskListBinding
import hr.ferit.taskie.model.Task
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskListFragment : Fragment(), OnTaskEventListener {

    private lateinit var binding: FragmentTaskListBinding
    private lateinit var adapter: TaskAdapter
    private val viewModel: TaskListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(layoutInflater)
        binding.fabAddTask.setOnClickListener { showCreateNewTaskFragment() }
        setupRecyclerView()
        viewModel.tasks.observe(viewLifecycleOwner) {
            if (it != null && it.isNotEmpty()) {
                adapter.setTasks(it)
            }
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.taskListRvTasks.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = TaskAdapter()
        adapter.onTaskSelectedListener = this
        binding.taskListRvTasks.adapter = adapter
    }

    companion object {
        val Tag = "TasksList"

        fun create(): Fragment {
            return TaskListFragment()
        }
    }

    override fun onTaskSelected(id: Long?) {
        val action =
            TaskListFragmentDirections.actionTaskListFragmentToTaskDetailsFragment(id ?: -1)
        findNavController().navigate(action)
    }

    override fun onTaskLongPress(task: Task?): Boolean {
        task?.let { it ->
            viewModel.delete(it)
        }
        return true
    }

    private fun showCreateNewTaskFragment() {
        val action = TaskListFragmentDirections.actionTaskListFragmentToNewTaskFragment()
        findNavController().navigate(action)
    }
}

