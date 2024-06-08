package com.github.mrf1n.threeninethclassic.training.T4344

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper
import com.github.mrf1n.threeninethclassic.training.CccSolver
import kotlin.math.ceil
import kotlin.math.min

fun main() {
    T4344_Level6().solve()
}

class T4344_Level6 : CccSolver {
    override val solutionWrapper: CccSolutionWrapper = CccSolutionWrapper("T4344", 6, checkAnswer = false)
    override fun solve() {
        solutionWrapper.runLevel { fileName, input, output ->
            val maxPower = input.nextInt()
            val maxBill = input.nextLong()
            val maxConcurrentTasks = input.nextInt()
            val numberOfMinutes = input.nextInt()
            val minutes: MutableList<Minute> = mutableListOf()
            for (i in 1..numberOfMinutes) {
                val price = input.nextInt()
                minutes.add(Minute(i, maxPower, maxConcurrentTasks, price))
            }
            val numberOfTasks = input.nextInt()
            val tasks: MutableList<Task> = mutableListOf()
            for (i in 0 until numberOfTasks) {
                val taskId = input.nextInt()
                val taskPower = input.nextInt()
                val startRange = input.nextInt()
                val endRange = input.nextInt()
                tasks.add(Task(taskId, taskPower, IntRange(startRange, endRange)))
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
                        .sortedBy(Pair<Int, Int>::second)
                        .joinToString(" ") { pair -> "${pair.first} ${pair.second}" }
                    output.println("${it.id} $results")
                    if (it.remainingPower > 0) {
                        println("Task=${it.id}, remaining=${it.remainingPower}")
                    }
                }
        }
    }

    private fun calculateMinimumBill(minutes: List<Minute>, tasks: List<Task>): Long {
        val minuteMap = minutes.associateBy { it.id }
        tasks.map { task ->
            val minuteList = task.range.mapNotNull { minuteId -> minuteMap[minuteId] }
            task.registerMinutes(minuteList)
            task.prepareRatios()
            task
        }
        minutes.sortedBy { it.basePrice }.forEach { minute ->
            calculateMinute(minute)
        }
        return minutes.sumOf { minute ->
            ceil(minute.basePrice * (1 + minute.powerConsumed.toDouble() / minute.maxPower)).toLong() * minute.powerConsumed
        }
    }

    private fun calculateMinute(minute: Minute) {
        val sortedTasks = minute.applicableTasks.sortedByDescending { it.minuteFactor[minute.id] }
        while (minute.remainingPower > 0 &&
            minute.maxConcurrentTasks > minute.taskPowerMap.count() &&
            sortedTasks.any { it.remainingPower > 0 }) {
            val task = sortedTasks.first { it.remainingPower > 0 }
            calculateTaskMinute(task, minute)
        }
    }

    private fun calculateTask(task: Task) {
        while (task.remainingPower > 0) {
            val minute = task.applicableMinutes.first { minute ->
                minute.remainingPower > 0 && minute.taskPowerMap.count() < minute.maxConcurrentTasks
            }
            calculateTaskMinute(task, minute)
        }
    }

    private fun calculateTaskMinute(task: Task, minute: Minute) {
        val consumedPower = min(minute.remainingPower, task.remainingPower)
        task.minutePowerList.add(Pair(minute.id, consumedPower))
        task.remainingPower -= consumedPower
        minute.remainingPower -= consumedPower
        minute.taskPowerMap.compute(task.id) { _, oldValue ->
            consumedPower + (oldValue ?: 0)
        }
    }

    data class Minute(
        val id: Int,
        val maxPower: Int,
        val maxConcurrentTasks: Int,
        val basePrice: Int,
        var remainingPower: Int = maxPower
    ) {
        var applicableTasks = mutableSetOf<Task>()
        var taskPowerMap = mutableMapOf<Int, Int>()
        val powerConsumed: Int
            get() {
                return maxPower - remainingPower
            }
    }

    data class Task(
        val id: Int,
        var initPower: Int,
        val range: IntRange,
        var remainingPower: Int = initPower
    ) {
        var applicableMinutes = mutableSetOf<Minute>()
        var minuteFactor: MutableMap<Int, Double> = mutableMapOf()
        var bill: Long = 0
        var minutePowerList: MutableList<Pair<Int, Int>> = mutableListOf()

        fun registerMinute(minute: Minute) {
            applicableMinutes.add(minute)
            minute.applicableTasks.add(this)
        }

        fun registerMinutes(minutes: List<Minute>) {
            minutes.forEach { minute -> registerMinute(minute) }
        }

        fun prepareRatios() {
            val totalPossiblePower = applicableMinutes.sumOf { it.maxPower }
            applicableMinutes.forEach {
                this.minuteFactor[it.id] = (applicableMinutes.count() / applicableMinutes.count()).toDouble() +
                        (it.maxPower / totalPossiblePower).toDouble()
            }
        }
    }

}

