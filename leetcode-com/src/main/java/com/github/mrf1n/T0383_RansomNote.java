package com.github.mrf1n;

import java.util.HashMap;
import java.util.Map;

public class T0383_RansomNote {

    public static void main(String[] args) {
        String rN0 = "a", magazine0 = "b";
        System.out.println(new T0383_RansomNote().canConstruct(rN0, magazine0));
        String rN1 = "aa", magazine1 = "ab";
        System.out.println(new T0383_RansomNote().canConstruct(rN1, magazine1));
        String rN2 = "aa", magazine2 = "aab";
        System.out.println(new T0383_RansomNote().canConstruct(rN2, magazine2));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);

            int currCount = letters.getOrDefault(m, 0);
            letters.put(m, currCount + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            int currCount = letters.getOrDefault(r, 0);

            if (currCount == 0) {
                return false;
            }

            letters.put(r, currCount - 1);
        }
        return true;
    }
}
