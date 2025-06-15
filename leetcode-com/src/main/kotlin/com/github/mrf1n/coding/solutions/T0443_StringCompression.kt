package com.github.mrf1n.coding.solutions

object T0443_StringCompression {
    fun compress(chars: CharArray): Int {
        var actualChar = chars[0]
        var actualCount = 0
        val result = StringBuilder()
        for (i in chars.indices) {
            if (chars[i] != actualChar) {
                result.append(actualChar)
                if (actualCount > 1) {
                    result.append(actualCount)
                }
                actualChar = chars[i]
                actualCount = 1
            } else {
                actualCount++
            }
            if (i == chars.size - 1) {
                result.append(actualChar)
                if (actualCount > 1) {
                    result.append(actualCount)
                }
            }
        }
        for (i in result.indices) {
            chars[i] = result[i]
        }
        return result.length
    }
}