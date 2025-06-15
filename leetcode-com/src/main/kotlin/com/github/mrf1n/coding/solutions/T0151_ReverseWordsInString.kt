package com.github.mrf1n.coding.solutions

object T0151_ReverseWordsInString {
    fun reverseWords(s: String): String {
        return s.split(" ")
            .filter { it.isNotBlank() }
            .reversed()
            .joinToString(" ")
    }


    fun reverseWords2(s: String): String {
        var r = s.length - 1
        var result = ""
        while (r >= 0) {
            while (r >= 0 && s[r] == ' ') r--
            var l = r
            while (l >= 0 && s[l] != ' ') l--
            if (l != r) {
                result = if (result == "") s.substring(l + 1, r + 1) else result + " " + s.substring(l + 1, r + 1)
            }
            r = l
        }
        return result
    }
}