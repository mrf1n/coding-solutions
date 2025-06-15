package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T1431_KidsWIthTheGreatestNumberOfCandiesTests {
    @Test
    fun `validate example test cases`() {
        T1431_KidsWIthTheGreatestNumberOfCandies.kidsWithCandies(
            candies = intArrayOf(2, 3, 5, 1, 3),
            extraCandies = 3
        ) shouldBe listOf(true, true, true, false, true)
        T1431_KidsWIthTheGreatestNumberOfCandies.kidsWithCandies(
            candies = intArrayOf(4, 2, 1, 1, 2),
            extraCandies = 1
        ) shouldBe listOf(true, false, false, false, false)
        T1431_KidsWIthTheGreatestNumberOfCandies.kidsWithCandies(
            candies = intArrayOf(12, 1, 12),
            extraCandies = 10
        ) shouldBe listOf(true, false, true)
    }
}