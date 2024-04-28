package com.github.mrf1n.threeninethclassic.training.T4344

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper
import com.github.mrf1n.threeninethclassic.training.CccSolver
import kotlin.math.min

fun main() {
    T4344_Level4().solve()
}

class T4344_Level4 : CccSolver {
    override val solutionWrapper = CccSolutionWrapper("T4344", 4, checkAnswer = false)

    override fun solve() {
        solutionWrapper.runLevel { fileName, input, output ->
            val maxPower = input.nextInt()
            val maxBill = input.nextInt()
            val numberOfMinutes = input.nextInt()
            val minutes: MutableList<Minute> = mutableListOf()
            for (i in 0 until numberOfMinutes) {
                val price = input.nextInt()
                minutes.add(Minute(i + 1, maxPower, price))
            }
            val numberOfTasks = input.nextInt()
            val tasks: MutableList<Task> = mutableListOf()
            for (i in 0 until numberOfTasks) {
                val taskId = input.nextInt()
                val taskPower = input.nextInt()
                val startRange = input.nextInt()
                val endRange = input.nextInt()
                tasks.add(Task(taskId, taskPower, startRange, endRange))
            }
            val calculatedBill = calculateMinimumBill(minutes, tasks)
            if (calculatedBill > maxBill) {
                println("Cannot solve task $fileName, calculatedBill=$calculatedBill, maxBill=$maxBill")
            } else {
                println("Task $fileName was solved, calculatedBill=$calculatedBill, maxBill=$maxBill")
            }
            output.println(numberOfTasks)
            tasks.sortedBy { it.id }
                .forEach {
                    val results = it.minutePowerList
                        .sortedBy(Pair<Int, Int>::first)
                        .joinToString(" ") { pair -> "${pair.first} ${pair.second}" }
                    output.println("${it.id} $results")
                }
        }
    }

    private fun calculateMinimumBill(minutes: List<Minute>, tasks: List<Task>): Int {
        val sortedMinutes = minutes.sortedBy { it.price }
        val sortedTasks = tasks.sortedBy { it.endRange - it.startRange }
        return sortedTasks.sumOf { calculateTask(sortedMinutes, it) }
    }

    private fun calculateTask(minutes: List<Minute>, task: Task): Int {
        while (task.remainingPower > 0) {
            val minute = minutes.first { minute ->
                minute.remainingPower > 0 && task.startRange <= minute.id && task.endRange >= minute.id
            }
            val consumedPower = min(minute.remainingPower, task.remainingPower)
            task.bill += minute.price * consumedPower
            task.minutePowerList.add(Pair(minute.id, consumedPower))
            task.remainingPower -= consumedPower
            minute.remainingPower -= consumedPower
        }
        return task.bill
    }

    data class Minute(
        val id: Int,
        val initPower: Int,
        val price: Int,
        var remainingPower: Int = initPower
    )

    data class Task(
        val id: Int,
        var initPower: Int,
        val startRange: Int,
        val endRange: Int,
        var remainingPower: Int = initPower
    ) {
        var bill: Int = 0
        var minutePowerList: MutableList<Pair<Int, Int>> = mutableListOf()
    }
}
