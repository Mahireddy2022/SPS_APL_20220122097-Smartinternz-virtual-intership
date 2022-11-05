package com.example.grocerylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class TaskViewModel: ViewModel()
{
    var TaskItem = MutableLiveData<MutableList<TaskItem>>()
    init {
        TaskItem.value = mutableListOf()
    }

    fun addTaskItem(newTask: TaskItem)
    {
        val list = TaskItem.value
        list!!.add(newTask)
        TaskItem.postValue(list)
    }

    fun updateTaskItem(id: UUID, name: String, desc: String, dueTime: LocalTime?)
    {
        val list = TaskItem.value
        val task = list!!.find { it.id == id }!!
        task.name = name
        task.desc = desc
        task.dueTime = dueTime
        TaskItem.postValue(list)
    }

    fun setCompleted(taskItem: TaskItem)
    {
        val list = TaskItem.value
        val task = list!!.find { it.id == taskItem.id }!!
        if (task.completedDate == null)
            task.completedDate = LocalDate.now()
        TaskItem.postValue(list)
    }
}
