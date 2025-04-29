package com.github.mrf1n

fun main() {
    println(T1768_MergeStringsAlternately.mergeAlternately("ab", "pqrs"))
}

object T1768_MergeStringsAlternately {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = StringBuilder()

        for (i in 0 until maxOf(word1.length, word2.length)) {
            if (i < word1.length) {
                result.append(word1[i])
            }
            if (i < word2.length) {
                result.append(word2[i])
            }
        }

        return result.toString()
    }
}