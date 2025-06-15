package com.github.mrf1n.coding.solutions

import kotlin.math.min

object T1071_GreatestCommonDivisorOfStrings {
    fun gcdOfStrings(str1: String, str2: String): String {
        var largest = ""
        val str1Len = str1.length
        val str2Len = str2.length
        for (i in min(str1Len, str2.length) downTo 1) {
            val substr = str1.substring(0, i)
            val substrLen = substr.length
            if (str1Len % substrLen == 0 && str2Len % substrLen == 0) {
                var match = true
                for (j in 0..str1Len / substrLen - 1) {
                    if (substr != str1.substring(j * substrLen, (j + 1) * substrLen)) {
                        match = false
                        break
                    }
                }
                for (j in 0..str2Len / substrLen - 1) {
                    if (substr != str2.substring(j * substrLen, (j + 1) * substrLen)) {
                        match = false
                        break
                    }
                }
                if (match) {
                    largest = substr
                    break
                }
            }
        }
        return largest
    }
}

object T1071_GreatestCommonDivisorOfStringsOptimized {
    fun gcdOfStrings(str1: String, str2: String): String {
        val len1 = str1.length
        val len2 = str2.length
        for (i in min(len1, len2) downTo 1) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i)
            }
        }
        return ""
    }

    fun valid(str1: String, str2: String, k: Int): Boolean {
        val len1 = str1.length
        val len2 = str2.length
        if (len1 % k > 0 || len2 % k > 0) {
            return false
        } else {
            val base = str1.substring(0, k)
            return str1.replace(base, "").isEmpty()
                    && str2.replace(base, "").isEmpty()
        }
    }
}