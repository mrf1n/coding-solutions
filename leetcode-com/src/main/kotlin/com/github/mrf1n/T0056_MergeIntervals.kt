package com.github.mrf1n

import java.util.*
import kotlin.math.max

fun main() {
    println(
        T0056_MergeIntervals.merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        ).contentDeepToString()
    )
    println(
        T0056_MergeIntervals.merge(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(4, 5)
            )
        ).contentDeepToString()
    )
}

object T0056_MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith { a, b -> a[0].compareTo(b[0]) }
        val merged = LinkedList<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty || merged.last()[1] < interval[0]) {
                merged.add(interval)
            } else {
                merged.last()[1] = max(merged.last()[1], interval[1])
            }
        }
        return merged.toTypedArray()
    }
}