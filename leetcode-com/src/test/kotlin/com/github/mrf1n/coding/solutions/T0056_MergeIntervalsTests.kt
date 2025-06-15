package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T0056_MergeIntervalsTests {
    @Test
    fun `validate example test cases`() {
        T0056_MergeIntervals.merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        ) shouldBe arrayOf(
            intArrayOf(1, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
        T0056_MergeIntervals.merge(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(4, 5)
            )
        ) shouldBe arrayOf(
            intArrayOf(1, 5)
        )
    }
}