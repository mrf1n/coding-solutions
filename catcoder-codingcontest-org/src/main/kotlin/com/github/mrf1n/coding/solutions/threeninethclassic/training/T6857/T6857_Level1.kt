package com.github.mrf1n.coding.solutions.threeninethclassic.training.T6857

import com.github.mrf1n.coding.solutions.threeninethclassic.training.CccSolutionWrapper

fun main() {
    val inputOutput = CccSolutionWrapper("T6857", "Lawn Mower", 1)
    inputOutput.runLevel { _, input, output ->
        val count = input.nextInt()
        for (i in 0 until count) {
            output.println(countWASD(input.nextLine()))
        }
    }
}

fun countWASD(text: String): String {
    val countW = text.count { it == 'W' }
    val countD = text.count { it == 'D' }
    val countS = text.count { it == 'S' }
    val countA = text.count { it == 'A' }
    return "$countW $countD $countS $countA"
}
