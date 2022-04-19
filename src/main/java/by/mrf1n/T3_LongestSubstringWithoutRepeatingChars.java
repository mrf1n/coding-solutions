package by.mrf1n;

import java.util.HashSet;
import java.util.Set;

public class T3_LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String s0 = "abcdabcbb";
        System.out.println(lengthOfLongestSubstringArray(s0));
//        String s1 = "azAZ019";
//        System.out.println(lengthOfLongestSubstringArray(s1));
    }

    public static int lengthOfLongestSubstringSet(String s) {
        int out = 0, l = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(i));
            out = Math.max(i - l + 1, out);
        }
        return out;
    }

    public static int lengthOfLongestSubstringArray(String s) {
        int out = 0, l = 0;
        int[] count = new int[128];

        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r)]++;
            while (count[s.charAt(r)] > 1) {
                count[s.charAt(l++)]--;
            }
            out = Math.max(r - l + 1, out);
        }
        return out;
    }
}
