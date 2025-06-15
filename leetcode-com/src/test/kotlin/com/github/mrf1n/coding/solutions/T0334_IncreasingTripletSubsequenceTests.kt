package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T0334_IncreasingTripletSubsequenceTests {

    @Test
    fun `validate example test cases`() {
        T0334_IncreasingTripletSubsequence.increasingTriplet(intArrayOf(1, 2, 3, 4, 5)) shouldBe true
        T0334_IncreasingTripletSubsequence.increasingTriplet(intArrayOf(5, 4, 3, 2, 1)) shouldBe false
        T0334_IncreasingTripletSubsequence.increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)) shouldBe true
        T0334_IncreasingTripletSubsequence.increasingTriplet(intArrayOf(0, 4, 2, 1, 0, -1, -3)) shouldBe false
    }
}