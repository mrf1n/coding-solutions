package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T0238_ProductOfArrayExceptSelfTests {

    @Test
    fun `validate example test cases`() {
        T0238_ProductOfArrayExceptSelf.productExceptSelf(intArrayOf(1, 2, 3, 4)) shouldBe intArrayOf(24, 12, 8, 6)

    }
}