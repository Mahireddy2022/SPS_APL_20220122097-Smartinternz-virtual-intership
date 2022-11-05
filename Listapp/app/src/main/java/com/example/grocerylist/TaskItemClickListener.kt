package com.example.grocerylist

interface TaskItemClickListener {
    fun editTaskItem(TaskItems: TaskItem)
    fun completeTaskItem(TaskItems: TaskItem)
}
