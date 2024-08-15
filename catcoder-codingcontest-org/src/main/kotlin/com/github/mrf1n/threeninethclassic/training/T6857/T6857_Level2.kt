package com.github.mrf1n.threeninethclassic.training.T6857

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper
import com.github.mrf1n.threeninethclassic.training.CccSolver
import kotlin.math.max
import kotlin.math.min

fun main() {
    T6857_Level2().solve()
}

class T6857_Level2: CccSolver {
    override val solutionWrapper = CccSolutionWrapper("T6857", "Lawn Mower", 2)

    override fun solve() {
        solutionWrapper.runLevel { _, input, output ->
            val count = input.nextInt()
            for (i in 0 until count) {
                val message = countTable(input.nextLine())
                output.println("${message.first} ${message.second}")
            }
        }
    }

    private fun countTable(path: String): Pair<Int, Int> {
        var x = 0
        var xMax = 0
        var xMin = 0
        var y = 0
        var yMax = 0
        var yMin = 0
        for (move in path) {
            when (move) {
                'W' -> y = y.inc()
                'D' -> x = x.inc()
                'S' -> y = y.dec()
                'A' -> x = x.dec()
            }
            xMax = max(xMax, x)
            yMax = max(yMax, y)
            xMin = min(xMin, x)
            yMin = min(yMin, y)
        }
        return Pair(xMax - xMin + 1, yMax - yMin + 1)
    }
}
