package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Given a fresh Tasks
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )
        // When calling our function
        val result = getActiveAndCompletedStats(tasks)

        // Then Check the result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    //If there is one completed task and no active tasks,
    // the activeTasks percentage should be 0f,
    // the completed tasks percentage should be 100f.
    @Test
    fun getActiveAndCompletedStats_oneCompleted_returnsHundredZero() {

        // Given a fresh Tasks
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true)

        )
        // When calling our function
        val result = getActiveAndCompletedStats(tasks)

        // Then Check the result
        assertThat(result.completedTasksPercent, `is`(100f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    //If there are two completed tests and three active test,
    // the completed percentage should be 40f and the active percentage should be 60f.
    @Test
    fun getActiveAndCompletedStats_twoCompleted_returnsSixtyForty() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)

        )
        // When calling our function
        val result = getActiveAndCompletedStats(tasks)

        // Then Check the result
        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }


    // If there is an empty list (emptyList()), then both percentages should be 0f.
    //If there was an error loading tasks, the list will be null, then both percentages should be 0f.
    @Test
    fun getActiveAndCompletedStats_emptyList_returnsZeros() {

        // Create an active tasks (the false makes this active)
        val tasks = emptyList<Task>()

        // When calling our function
        val result = getActiveAndCompletedStats(tasks)

        // Then Check the result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_nullList_returnsZeros() {

        // Create an active tasks (the false makes this active)
        val tasks = null

        // When calling our function
        val result = getActiveAndCompletedStats(tasks)

        // Then Check the result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }
}
