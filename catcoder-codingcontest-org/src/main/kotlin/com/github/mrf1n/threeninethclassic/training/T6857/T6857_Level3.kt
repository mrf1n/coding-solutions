package com.github.mrf1n.threeninethclassic.training.T6857

import com.github.mrf1n.threeninethclassic.training.CccSolutionWrapper
import com.github.mrf1n.threeninethclassic.training.CccSolver

fun main() {
    T6857_Level3().solve()
}

class T6857_Level3: CccSolver {
    override val solutionWrapper = CccSolutionWrapper("T6857", "Lawn Mower", 3)

    override fun solve() {
        solutionWrapper.runLevel { _, input, output ->
            val count = input.nextInt()
            for (i in 0 until count) {
                val width = input.nextInt()
                val height = input.nextInt()
                for (j in 0 until height) {
                    input.nextLine()
                }
                val path = input.nextLine()
                val result = countPath(width, height, path)
                output.println(result)
            }
        }
    }

    data class Cell(val x: Int, val y: Int)

    class Table(
        val width: Int,
        val height: Int,
        private var positionX: Int = 0,
        private var positionY: Int = 0
    ) {

        private var leftBorder = 0
        private var rightBorder = 0
        private var upBorder = 0
        private var downBorder = 0
        val cells = mutableMapOf<String, Cell>()

        fun moveUp(): Boolean {
            return moveY(1) && saveCell()
        }

        fun moveDown(): Boolean {
            return moveY(-1) && saveCell()
        }

        fun moveRight(): Boolean {
            return moveX(1) && saveCell()
        }

        fun moveLeft(): Boolean {
            return moveX(-1) && saveCell()
        }

        private fun saveCell(): Boolean {
            return when {
                cells.containsKey("$positionX|$positionY") -> {
                    false
                }

                else -> {
                    cells["$positionX|$positionY"] = Cell(positionX, positionY)
                    true
                }
            }
        }

        private fun moveX(value: Int): Boolean {
            positionX += value
            if (positionX > rightBorder) {
                rightBorder = positionX
            }
            if (positionX < leftBorder) {
                leftBorder = positionX
            }
            return true
        }

        private fun moveY(value: Int): Boolean {
            positionY += value
            if (positionY > upBorder) {
                upBorder = positionY
            }
            if (positionY < downBorder) {
                downBorder = positionY
            }
            return true
        }
    }

    fun countPath(width: Int, height: Int, text: String): String {
        val table = Table(width, height)
        for (c in text) {
            when (c) {
                'W' -> table.moveUp()
                'D' -> table.moveRight()
                'S' -> table.moveDown()
                'A' -> table.moveLeft()
            }
        }
        return "VALID"
    }
}
