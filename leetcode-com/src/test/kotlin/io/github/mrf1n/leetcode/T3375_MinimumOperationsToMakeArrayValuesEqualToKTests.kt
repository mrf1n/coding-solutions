package io.github.mrf1n.leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T3375_MinimumOperationsToMakeArrayValuesEqualToKTests {
    @Test
    fun `validate example test cases`() {
        T3375_MinimumOperationsToMakeArrayValuesEqualToK.minOperations(intArrayOf(), 5) shouldBe 0
    }
}