package com.github.mrf1n.threeninethclassic.training.T4344

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper

fun main() {
    val inputOutput = CccSolutionWrapper("T4344", 1)
    inputOutput.runLevel { input, output ->
        val count = input.nextInt()
        val array = IntRange(0, count - 1).map { input.nextInt() }.toIntArray()
        output.println(findMin(array))
    }
}

fun findMin(array: IntArray): Int {
    var minInd = 0
    for ((index, i) in array.withIndex()) {
        if (array[index] < array[minInd]) {
            minInd = index
        }
    }
    return minInd
}