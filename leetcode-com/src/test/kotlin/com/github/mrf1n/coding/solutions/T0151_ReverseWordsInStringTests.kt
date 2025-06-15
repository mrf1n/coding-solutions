package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T0151_ReverseWordsInStringTests {

    @Test
    fun `validate example test cases for first solution`() {
        T0151_ReverseWordsInString.reverseWords("the sky is blue") shouldBe "blue is sky the"
        T0151_ReverseWordsInString.reverseWords("  hello world  ") shouldBe "world hello"
        T0151_ReverseWordsInString.reverseWords("a good   example") shouldBe "example good a"
    }

    @Test
    fun `validate example test cases for second solution`() {
        T0151_ReverseWordsInString.reverseWords2("the sky is blue") shouldBe "blue is sky the"
        T0151_ReverseWordsInString.reverseWords2("  hello world  ") shouldBe "world hello"
        T0151_ReverseWordsInString.reverseWords2("a good   example") shouldBe "example good a"
    }
}