package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T1071_GreatestCommonDivisorOfStringsTests {
    @Test
    fun `validate example test cases`() {
        T1071_GreatestCommonDivisorOfStrings.gcdOfStrings("ABCABC", "ABC") shouldBe "ABC"
        T1071_GreatestCommonDivisorOfStrings.gcdOfStrings("ABABAB", "ABAB") shouldBe "AB"
        T1071_GreatestCommonDivisorOfStrings.gcdOfStrings("LEET", "CODE") shouldBe ""
    }

    @Test
    fun `validate example test cases for optimized solution`() {
        T1071_GreatestCommonDivisorOfStringsOptimized.gcdOfStrings("ABCABC", "ABC") shouldBe "ABC"
        T1071_GreatestCommonDivisorOfStringsOptimized.gcdOfStrings("ABABAB", "ABAB") shouldBe "AB"
        T1071_GreatestCommonDivisorOfStringsOptimized.gcdOfStrings("LEET", "CODE") shouldBe ""
    }
}