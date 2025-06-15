package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T0443_StringCompressionTests {

    @Test
    fun `validate example test cases`() {
        T0443_StringCompression.compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')) shouldBe 6
        T0443_StringCompression.compress(charArrayOf('a')) shouldBe 1
        T0443_StringCompression.compress(
            charArrayOf(
                'a',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b',
                'b'
            )
        ) shouldBe 4
        T0443_StringCompression.compress(charArrayOf('a', 'b', 'c')) shouldBe 3
    }
}