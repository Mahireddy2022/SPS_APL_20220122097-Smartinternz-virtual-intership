package com.example.grocerylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerylist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),TaskItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(taskItem = null).show(supportFragmentManager, "newTaskTag")
        }
        setRecycleView()

    }

    private fun setRecycleView() {

        val mainActivity = this
        taskViewModel.TaskItem.observe(this) {
            binding.ListappRecylerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it, mainActivity)
            }
        }
    }
    override fun editTaskItem(TaskItems: TaskItem)
    {
        NewTaskSheet(TaskItems).show(supportFragmentManager,"newTaskTag")
    }

    override fun completeTaskItem(TaskItems: TaskItem)
    {
        taskViewModel.setCompleted(TaskItems)
    }
}
