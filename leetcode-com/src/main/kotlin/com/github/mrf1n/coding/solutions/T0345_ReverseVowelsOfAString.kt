package com.github.mrf1n.coding.solutions

object T0345_ReverseVowelsOfAString {
    fun reverseVowels(s: String): String {
        val cs = s.toCharArray()
        val vowels = listOf('a', 'e', 'i', 'o', 'u')
        var l = 0
        var r = cs.size - 1
        while (l < r) {
            while (l < cs.size && !vowels.contains(cs[l].lowercaseChar())) l++
            while (r >= 0 && !vowels.contains(cs[r].lowercaseChar())) r--
            if (l < r) {
                val buff = cs[l]
                cs[l] = cs[r]
                cs[r] = buff
                l++; r--
            }
        }
        return cs.concatToString()
    }
}