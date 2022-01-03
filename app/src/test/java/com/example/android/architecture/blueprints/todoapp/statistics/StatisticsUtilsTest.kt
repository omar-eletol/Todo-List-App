package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)
    }

    //If there is one completed task and no active tasks,
    // the activeTasks percentage should be 0f,
    // the completed tasks percentage should be 100f.
    @Test
    fun getActiveAndCompletedStats_oneCompleted_returnsHundredZero() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true)

        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 100f)
        assertEquals(result.activeTasksPercent, 0f)
    }
}
