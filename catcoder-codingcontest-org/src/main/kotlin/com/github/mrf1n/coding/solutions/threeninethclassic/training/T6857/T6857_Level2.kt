package com.github.mrf1n.threeninethclassic.training.T6857

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper

fun main() {
    val inputOutput = CccSolutionWrapper("T6857", "Lawn Mower", 2)
    inputOutput.runLevel { _, input, output ->
        val count = input.nextInt()
        for (i in 0 until count) {
            val message = countTable(input.nextLine())
            output.println("${message.first} ${message.second}")
        }
    }
}

fun countTable(text: String): Pair<Int, Int> {
    var with = 0
    var withMax = 0
    var withMin = 0
    var heigh = 0
    var heighMax = 0
    var heighMin = 0
    for (c in text) {
        when (c) {
            'W' -> heigh = heigh.inc()
            'D' -> with = with.inc()
            'S' -> heigh = heigh.dec()
            'A' -> with = with.dec()
        }
        if (with > withMax) {
            withMax = with
        }
        if (heigh > heighMax) {
            heighMax = heigh
        }
        if (with < withMin) {
            withMin = with
        }
        if (heigh < heighMin) {
            heighMin = heigh
        }
    }
    return Pair(withMax - withMin + 1, heighMax - heighMin + 1)
}
