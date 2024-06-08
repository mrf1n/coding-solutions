package com.github.mrf1n.threeninethclassic.training.T6589

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper

fun main() {
    val inputOutput = CccSolutionWrapper("T6589", "Lawn Mower (on-site)",4)
    inputOutput.runLevel { _, input, output ->
        val count = input.nextInt()
        for (i in 0 until count) {
            val col = input.nextInt()
            val row = input.nextInt()
            val map = IntRange(0, row - 1).map {
                input.nextLine().toCharArray()
            }.toTypedArray()
            var solveMap = solveMap(0, 0, map)
            if (!solveMap.first) {
                solveMap = solveMap(0, 0, map)
            }
            if (!solveMap.first) {
                solveMap = solveMap(0, map[0].size - 1, map)
            }
            if (!solveMap.first) {
                solveMap = solveMap(map.size - 1, map[0].size - 1, map)
            }
            output.println(solveMap.second)
        }
    }
}

fun solveMap(x: Int, y: Int, map: Array<CharArray>, path: String = ""): Pair<Boolean, String> {
    map[x][y] = 'x'
//    for (i in map.indices) {
//        for (j in map[0].indices) {
//            print("${map[i][j]}")
//        }
//        println()
//    }
//    println(path)
    if (checkSolved(map)) {
        return Pair(true, path)
    }
    if (x > 0 && map[x - 1][y] == '.') {
        val pair = solveMap(x - 1, y, map.deepCopy(), "${path}W")
        if (pair.first) {
            return pair
        }
    }
    if (y + 1 < map[0].size && map[x][y + 1] == '.') {
        val pair = solveMap(x, y + 1, map.deepCopy(), "${path}D")
        if (pair.first) {
            return pair
        }
    }
    if (y > 0 && map[x][y - 1] == '.') {
        val pair = solveMap(x, y - 1, map.deepCopy(), "${path}A")
        if (pair.first) {
            return pair
        }
    }
    if (x + 1 < map.size && map[x + 1][y] == '.') {
        val pair = solveMap(x + 1, y, map.deepCopy(), "${path}S")
        if (pair.first) {
            return pair
        }
    }
    return Pair(false, path)
}

fun checkSolved(map: Array<CharArray>): Boolean {
    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] == '.') {
                return false
            }
        }
    }
    return true
}

fun Array<CharArray>.deepCopy(): Array<CharArray> {
    return Array(size) { this[it].clone() }
}
