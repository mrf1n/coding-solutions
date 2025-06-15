package com.github.mrf1n.coding.solutions

object T0605_CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var remainsN = n
        var previousPotHasNewFlower = false
        for (i in flowerbed.indices) {
            if (remainsN == 0) break

            val emptyPreviousPot = (i - 1 < 0 || flowerbed[i - 1] == 0) && !previousPotHasNewFlower
            val emptyNextPot = i + 1 >= flowerbed.size || flowerbed[i + 1] == 0

            if (flowerbed[i] == 0 && emptyPreviousPot && emptyNextPot) {
                remainsN--
                previousPotHasNewFlower = true
            } else {
                previousPotHasNewFlower = false
            }
        }
        return remainsN == 0
    }

    fun canPlaceFlowers2(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        for (i in flowerbed.indices) {
            if (flowerbed[i] == 0) {
                val emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0)
                val emptyRightPlot = (i == flowerbed.size - 1) || (flowerbed[i + 1] == 0)

                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1
                    count++
                    if (count >= n) {
                        return true
                    }
                }
            }
        }
        return count >= n
    }
}