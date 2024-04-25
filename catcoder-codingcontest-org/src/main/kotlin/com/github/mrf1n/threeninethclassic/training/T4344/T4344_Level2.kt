package com.github.mrf1n.threeninethclassic.training.T4344

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper

fun main() {
    val inputOutput = CccSolutionWrapper("T4344", 2)
    inputOutput.runLevel { input, output ->
        val minutes: Int = input.nextInt()
        val array = IntArray(minutes)
        for (i in 0 until minutes) {
            array[i] = input.nextInt()
        }
        val tests: Int = input.nextInt()
        output.println(tests)
        for (i in 0 until tests) {
            val testNum: Int = input.nextInt()
            val testDuration: Int = input.nextInt()
            val startRange = getStartRange(array, testDuration)
            output.println("$testNum $startRange")
        }
    }
}

private fun getStartRange(array: IntArray, duration: Int): Int {
    var range = Int.MAX_VALUE
    var rangeIndex = -1
    for (i in 0 until array.size - duration + 1) {
        val newRange = countRange(array, i, duration)
        if (newRange < range) {
            range = newRange
            rangeIndex = i
        }
    }
    return rangeIndex
}

private fun countRange(array: IntArray, start: Int, duration: Int): Int {
    var range = 0
    for (i in start until start + duration) {
        range += array[i]
    }
    return range
}
