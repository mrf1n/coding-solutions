package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T1768_MergeStringsAlternatelyTests {
    @Test
    fun `validate example test cases`() {
        T1768_MergeStringsAlternately.mergeAlternately("abc", "pqr") shouldBe "apbqcr"
        T1768_MergeStringsAlternately.mergeAlternately("ab", "pqrs") shouldBe "apbqrs"
        T1768_MergeStringsAlternately.mergeAlternately("abcd", "pq") shouldBe "apbqcd"
    }
}