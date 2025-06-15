package com.github.mrf1n.coding.solutions

import java.util.*
import kotlin.math.max

object T0056_MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith { a, b -> a[0].compareTo(b[0]) }
        val merged = LinkedList<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty() || merged.last()[1] < interval[0]) {
                merged.add(interval)
            } else {
                merged.last()[1] = max(merged.last()[1], interval[1])
            }
        }
        return merged.toTypedArray()
    }
}