package hr.ferit.taskie.ui.task_new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.ferit.taskie.R
import hr.ferit.taskie.model.TaskPriority
import hr.ferit.taskie.databinding.FragmentNewTaskBinding
import hr.ferit.taskie.utils.getDate
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewTaskFragment : Fragment() {

    private lateinit var binding: FragmentNewTaskBinding
    private val viewModel: TaskNewViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTaskBinding.inflate(layoutInflater)
        binding.bSaveTask.setOnClickListener{saveTask()}
        return binding.root
    }

    private fun saveTask() {
        val title = binding.etTaskTitleInput.text.toString()
        val contents = binding.etTaskContentsInput.text.toString()
        val priority = when(binding.rgPriorityInput.checkedRadioButtonId){
            R.id.rb_priority_high -> TaskPriority.High
            R.id.rb_priority_medium -> TaskPriority.Medium
            R.id.rb_priority_low -> TaskPriority.Low
            else -> TaskPriority.Low
        }
        val dateAdded = binding.dpDateAddedInput.getDate()

        viewModel.save(title, contents, priority, dateAdded)

        Toast.makeText(context, getString(R.string.message_saving), Toast.LENGTH_SHORT).show()
        val action = NewTaskFragmentDirections.actionNewTaskFragmentToTaskListFragment()
        findNavController().navigate(action)
    }

    companion object {
        val Tag = "NewTask"

        fun create(): Fragment {
            return NewTaskFragment()
        }
    }
}