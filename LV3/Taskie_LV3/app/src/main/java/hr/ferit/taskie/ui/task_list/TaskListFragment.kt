package hr.ferit.taskie.ui.task_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.taskie.databinding.FragmentTaskListBinding
import hr.ferit.taskie.di.TaskRepositoryFactory
import hr.ferit.taskie.model.Task

class TaskListFragment : Fragment(), OnTaskEventListener {

    private lateinit var binding: FragmentTaskListBinding
    private lateinit var adapter: TaskAdapter
    private val taskRepository = TaskRepositoryFactory.taskRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(layoutInflater)
        setupRecyclerView()
        binding.fabAddNote.setOnClickListener { showCreateNewTaskFragment() }
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

    override fun onResume() {
        super.onResume()
        updateData()
    }

    private fun updateData() {
        adapter.setTasks(taskRepository.getAllTasks())
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
            taskRepository.delete(it)
            adapter.setTasks(taskRepository.getAllTasks())
        }
        return true
    }

    private fun showCreateNewTaskFragment() {
        val action = TaskListFragmentDirections.actionTaskListFragmentToNewTaskFragment()
        findNavController().navigate(action)
    }
}

