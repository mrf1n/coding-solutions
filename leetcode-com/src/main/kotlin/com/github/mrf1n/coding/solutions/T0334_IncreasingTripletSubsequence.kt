package com.github.mrf1n.coding.solutions

object T0334_IncreasingTripletSubsequence {
    fun increasingTriplet(nums: IntArray): Boolean {
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE
        for (n in nums) {
            if (n <= first) {
                first = n
            } else if (n <= second) {
                second = n
            } else {
                return true
            }
        }
        return false
    }
}