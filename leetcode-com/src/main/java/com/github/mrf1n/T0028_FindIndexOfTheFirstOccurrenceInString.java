package com.github.mrf1n;

public class T0028_FindIndexOfTheFirstOccurrenceInString {

    public static void main(String[] args) {
        String h0 = "sadbutsad", n0 = "sad";
        System.out.println(new T0028_FindIndexOfTheFirstOccurrenceInString().strStr(h0, n0));

        String h1 = "sadbutsad", n1 = "sadd";
        System.out.println(new T0028_FindIndexOfTheFirstOccurrenceInString().strStr(h1, n1));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = i;
                while (haystack.charAt(j) == needle.charAt(j - i)) {
                    j++;
                    if (j - i == needle.length()) {
                        return i;
                    }
                    if (j > haystack.length() - 1) {
                        return -1;
                    }
                }
            }
        }
        return -1;
    }
}
