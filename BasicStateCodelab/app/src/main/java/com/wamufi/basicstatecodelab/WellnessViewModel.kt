package com.wamufi.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) = _tasks.find { it.id == item.id }?.let { task ->
        task.checked = checked
    }
}

private fun getWellnessTasks() = List(30) { WellnessTask(it, "Task #$it") }