package com.github.mrf1n.threeninethclassic.training.T4344

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper

fun main() {
    val inputOutput = CccSolutionWrapper("T4344", 3)
    inputOutput.runLevel { _, input, output ->
        val minutes = input.nextInt()
        val array = IntArray(minutes)
        for (i in 0 until minutes) {
            array[i] = input.nextInt()
        }
        val tests = input.nextInt()
        output.println(tests)
        for (i in 0 until tests) {
            val testNum = input.nextInt()
            val testPower = input.nextInt()
            val startRange = input.nextInt()
            val endRange = input.nextInt()
            val minute = findMinWithRange(array, startRange, endRange)
            output.println("$testNum $minute $testPower")
        }
    }
}

private fun findMinWithRange(array: IntArray, start: Int, end: Int): Int {
    var minInd = start
    for (i in start..end) {
        if (array[i] < array[minInd]) {
            minInd = i
        }
    }
    return minInd
}
