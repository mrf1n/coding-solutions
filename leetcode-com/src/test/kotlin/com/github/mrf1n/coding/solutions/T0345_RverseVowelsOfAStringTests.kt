package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T0345_RverseVowelsOfAStringTests {

    @Test
    fun `validate example test cases`() {
        T0345_ReverseVowelsOfAString.reverseVowels("IceCreAm") shouldBe "AceCreIm"
        T0345_ReverseVowelsOfAString.reverseVowels("leetcode") shouldBe "leotcede"
        T0345_ReverseVowelsOfAString.reverseVowels(".,") shouldBe ".,"
    }
}