package com.github.mrf1n.coding.solutions

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class T0605_CanPlaceFlowersTests {
    @Test
    fun `validate example test cases`() {
        T0605_CanPlaceFlowers.canPlaceFlowers(flowerbed = intArrayOf(1, 0, 0, 0, 1), 1) shouldBe true
        T0605_CanPlaceFlowers.canPlaceFlowers(flowerbed = intArrayOf(1, 0, 0, 0, 1), 2) shouldBe false
        T0605_CanPlaceFlowers.canPlaceFlowers(flowerbed = intArrayOf(1, 0, 0, 0, 0, 0, 1), 2) shouldBe true
        T0605_CanPlaceFlowers.canPlaceFlowers(flowerbed = intArrayOf(0, 0, 0, 0, 0, 1, 0, 0), 0) shouldBe true
    }

    @Test
    fun `validate example test cases case second solution`() {
        T0605_CanPlaceFlowers.canPlaceFlowers2(flowerbed = intArrayOf(1, 0, 0, 0, 1), 1) shouldBe true
        T0605_CanPlaceFlowers.canPlaceFlowers2(flowerbed = intArrayOf(1, 0, 0, 0, 1), 2) shouldBe false
        T0605_CanPlaceFlowers.canPlaceFlowers2(flowerbed = intArrayOf(1, 0, 0, 0, 0, 0, 1), 2) shouldBe true
        T0605_CanPlaceFlowers.canPlaceFlowers2(flowerbed = intArrayOf(0, 0, 0, 0, 0, 1, 0, 0), 0) shouldBe true
    }
}