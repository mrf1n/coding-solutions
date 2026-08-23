package io.github.mrf1n.leetcode

object T1431_KidsWIthTheGreatestNumberOfCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maxCandies = candies.max()
        val hasGreatestCandiesNumberList = mutableListOf<Boolean>()
        for (kidCandies in candies) {
            hasGreatestCandiesNumberList.add(kidCandies + extraCandies >= maxCandies)
        }
        return hasGreatestCandiesNumberList
    }
}