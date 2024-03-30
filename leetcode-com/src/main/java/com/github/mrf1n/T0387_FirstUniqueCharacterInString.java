package com.github.mrf1n;

import java.util.HashMap;
import java.util.Map;

public class T0387_FirstUniqueCharacterInString {

    public static void main(String[] args) {
        String str0 = "leetcode";
        System.out.println(new T0387_FirstUniqueCharacterInString().firstUniqChar(str0));
        String str1 = "loveleetcode";
        System.out.println(new T0387_FirstUniqueCharacterInString().firstUniqChar(str1));
        String str2 = "aabb";
        System.out.println(new T0387_FirstUniqueCharacterInString().firstUniqChar(str2));
        String str3 = "aabb";
        System.out.println(new T0387_FirstUniqueCharacterInString().firstUniqCharBest(str3));
    }

    public int firstUniqChar(String s) {
        int index = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            map.put(s.charAt(i), count == null ? 1 : count + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count != null && count == 1) {
                index = i;
                return index;
            }
            map.remove(s.charAt(i));
            if (map.isEmpty()) {
                return index;
            }
        }
        return index;
    }

    public int firstUniqCharBest(String s) {
        if (s.length() == 0) {
            return -1;
        }
        int[] store = new int[26];
        for (char ch : s.toCharArray()) {
            store[ch - 'a']++;
        }

        for (int idx = 0; idx < s.length(); idx++) {
            if (store[s.charAt(idx) - 'a'] == 1) {
                return idx;
            }
        }
        return -1;
    }
}
