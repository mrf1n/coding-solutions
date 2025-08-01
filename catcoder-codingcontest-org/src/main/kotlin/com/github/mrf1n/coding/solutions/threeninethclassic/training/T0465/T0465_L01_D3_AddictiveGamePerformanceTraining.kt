package com.github.mrf1n.coding.solutions.threeninethclassic.training.T0465

import com.github.mrf1n.coding.solutions.threeninethclassic.training.InputReader

internal class FlowRound(
    val rows: Int,
    val cols: Int,
    val pointsCount: Int,
    val points: List<Triple<Int, Int, Int>>
) {
    val board = Array(rows) { Array(cols) { 0 } }

    init {
        points.forEach {
            val second = it.second - 1
            board[second.floorDiv(cols)][second.mod(cols)] = it.first
            val third = it.third - 1
            board[third.floorDiv(cols)][third.mod(cols)] = it.first
        }
    }

    fun printBoard() {
        board.forEach {
            println(it.contentToString())
        }
        println()
    }
}

fun main(args: Array<String>) {
    val str =
        "30 10 10 24 1 1 6 2 10 2 14 3 23 3 24 4 32 5 33 6 34 7 37 6 42 8 47 7 49 4 59 9 63 1 66 10 70 5 71 11 72 9 82 12 87 8 89 10 92 11 95 12 0 10 10 16 8 1 12 2 15 3 16 4 19 5 24 6 25 7 42 2 43 3 48 7 56 5 76 6 83 8 89 4 91 8 99 1 0 10 10 16 7 1 15 2 17 3 19 3 27 4 28 1 34 5 38 6 46 7 51 8 56 4 57 5 58 8 61 2 71 6 72 7 0 10 10 18 1 1 5 2 10 3 21 4 22 5 24 6 27 7 33 4 34 8 35 9 67 7 72 8 73 9 82 6 85 1 86 5 97 2 98 3 0 10 10 20 9 1 10 2 11 3 12 4 16 5 19 6 28 2 32 7 34 1 37 8 44 9 59 6 65 9 67 3 69 5 78 4 79 10 86 7 98 10 99 8 0 10 10 22 12 1 16 1 19 2 20 3 24 4 25 2 30 5 32 6 33 3 39 7 40 8 42 9 43 5 54 4 57 8 71 6 81 10 82 11 87 11 88 7 89 9 97 10 0 10 10 22 6 1 22 2 23 3 27 4 46 3 47 5 49 5 50 1 60 6 63 7 64 8 65 9 67 9 70 10 77 8 78 6 79 11 82 4 97 2 98 7 99 11 100 10 0 10 10 18 1 1 29 2 33 3 37 3 38 4 39 1 43 5 50 6 51 2 61 7 67 5 68 8 74 9 75 8 82 4 89 9 94 7 95 6 0 10 10 18 6 1 7 2 8 3 12 4 13 5 24 4 25 6 33 1 34 7 52 8 54 9 55 8 56 7 72 9 73 6 81 2 82 5 99 3 0 10 10 20 5 1 6 2 12 3 15 4 16 1 28 4 31 5 41 6 42 3 53 6 61 7 62 8 74 9 76 10 78 10 88 9 91 7 96 8 97 5 100 2 0 10 10 22 4 1 14 2 23 3 28 4 38 5 46 6 47 4 48 3 58 7 60 7 64 6 66 8 69 9 70 10 74 5 77 11 78 9 84 2 88 8 89 10 90 11 94 1 0 10 10 18 12 1 18 2 20 3 23 4 24 5 26 6 28 1 48 7 52 4 53 5 54 6 69 8 73 7 84 9 86 3 87 9 96 8 99 2 0 10 10 18 12 1 16 2 17 3 18 4 19 5 24 6 36 7 41 8 46 9 48 4 66 9 67 6 72 2 73 1 75 3 78 7 87 5 91 8 0 10 10 22 14 1 15 2 19 3 22 1 23 4 24 5 27 6 32 4 36 7 43 7 46 6 62 8 65 9 68 2 69 3 82 10 85 8 93 9 94 10 95 11 99 11 100 5 0 10 10 18 1 1 10 1 11 2 12 3 32 4 46 2 47 5 49 4 55 6 59 7 75 5 78 6 79 8 80 9 82 7 85 3 99 8 100 9 0 10 10 20 7 1 8 2 16 3 17 4 23 4 24 5 28 5 49 6 51 1 52 7 58 2 61 6 71 8 77 9 82 10 85 7 88 3 89 9 91 10 92 8 0 10 10 16 14 1 16 2 19 3 24 4 34 5 35 6 39 7 49 2 58 1 59 8 65 4 66 5 67 6 73 3 81 7 82 8 0 10 10 22 12 1 16 2 17 3 26 4 27 5 33 2 35 6 37 7 39 3 45 4 52 5 54 8 62 9 66 7 69 8 75 6 76 10 81 9 83 11 91 1 98 11 99 10 0 10 10 16 8 1 10 2 12 3 13 4 16 3 20 5 26 6 27 5 29 2 39 7 45 6 48 8 58 1 64 4 67 8 82 7 0 10 10 20 4 1 5 2 7 3 11 1 12 4 13 2 19 5 23 6 34 3 39 7 42 6 44 4 45 8 57 9 61 9 69 10 72 5 76 7 84 10 91 8 0 10 10 22 1 1 8 2 10 3 11 4 14 5 24 6 28 7 29 2 36 6 43 8 45 9 50 3 56 7 57 10 60 5 70 9 78 10 79 11 84 4 85 1 89 8 91 11 0 10 10 22 1 1 2 2 5 3 6 4 12 5 16 6 17 5 26 7 28 7 35 6 36 8 54 2 55 9 60 4 63 10 67 3 73 9 75 10 77 8 79 11 87 11 92 1 0 10 10 22 6 1 11 2 17 2 18 3 23 4 26 5 27 1 29 3 32 6 34 4 35 7 37 8 44 9 45 6 48 10 50 10 51 7 65 11 72 9 78 11 85 5 91 8 0 10 10 22 1 1 13 2 18 3 19 4 20 3 21 1 22 5 30 4 34 6 37 7 49 7 54 8 56 2 64 9 68 10 73 8 74 11 77 10 86 6 87 11 97 9 98 5 0 10 10 22 6 1 7 2 8 3 10 3 11 1 12 2 20 4 29 5 35 6 44 7 48 8 49 9 54 10 56 8 58 6 68 9 74 10 78 11 84 7 85 11 91 4 97 5 0 10 10 20 1 1 11 2 22 1 29 3 34 3 36 4 37 5 39 6 48 7 49 2 52 8 53 9 54 4 59 7 60 8 67 5 68 10 73 10 78 9 93 6 0 10 10 22 5 1 14 2 15 3 19 4 28 3 34 5 40 6 47 6 55 7 56 4 57 8 59 9 65 10 67 9 77 10 78 11 82 2 87 5 88 7 89 11 93 1 99 8 0 10 10 18 4 1 5 2 12 3 28 4 36 5 37 6 42 7 44 8 45 6 54 3 63 9 64 5 74 4 80 8 82 7 83 9 84 1 88 2 0 10 10 18 2 1 3 2 12 3 19 4 24 5 26 6 29 7 34 4 36 8 39 6 42 3 52 1 55 5 61 9 66 8 73 7 92 9 100 2 0 10 10 18 1 1 7 2 9 3 11 4 12 5 31 6 35 7 38 1 42 3 52 2 53 6 55 4 68 5 78 7 83 8 84 9 91 8 92 9 0"
    val reader = InputReader.fromString(str)
    val testsCount = reader.nextInt()
    val flowRounds = IntRange(1, testsCount).map {
        val rows = reader.nextInt()
        val cols = reader.nextInt()
        val pointsCount = reader.nextInt()
        val points = IntRange(1, pointsCount).map {
            val position = reader.nextInt()
            val color = reader.nextInt()
            color to position
        }.groupBy {
            it.first
        }.map {
            Triple(it.key, it.value[0].second, it.value[1].second)
        }
        reader.nextInt()
        FlowRound(rows, cols, pointsCount, points)
    }
    flowRounds.forEach {
        solveGame(it)
    }
}

internal fun solveGame(flowRound: FlowRound) {
    flowRound.printBoard()
}
