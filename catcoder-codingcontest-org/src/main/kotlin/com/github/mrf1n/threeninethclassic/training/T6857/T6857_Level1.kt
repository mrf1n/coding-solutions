package com.github.mrf1n.threeninethclassic.training.T6857

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper
import com.github.mrf1n.threeninethclassic.training.CccSolver

fun main() {
    T6857_Level1().solve()
}

class T6857_Level1 : CccSolver {
    override val solutionWrapper = CccSolutionWrapper("T6857", "Lawn Mower", 1)

    override fun solve() {
        solutionWrapper.runLevel { _, input, output ->
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
}
