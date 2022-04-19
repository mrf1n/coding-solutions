package by.mrf1n;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T567_PermutationInString {
    public static void main(String[] args) {
//        String s01 = "asadab", s02 = "osdasabaaedlscml";
//        System.out.println(checkInclusion(s01, s02));
//        String s11 = "ab", s12 = "eidboaoo";
//        System.out.println(checkInclusion(s11, s12));
//        String s21 = "adc", s22 = "dcda";
//        System.out.println(checkInclusion(s21, s22));
//        String s31 = "ab", s32 = "eidboaoo";
//        System.out.println(checkInclusion(s31, s32));
        String s41 = "aab", s42 = "oskfabaerwe";
        System.out.println(checkInclusion(s41, s42));
    }

    public static boolean checkInclusionWorst(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            map.merge(s1.charAt(i), 1, Integer::sum);
        }

        boolean out = false;
        Map<Character, Integer> tmpMap = new HashMap<>(map);
        int matches = 0, l = 0, r = 0;
        while (r < s2.length()) {
            char ch = s2.charAt(r);
            if (tmpMap.containsKey(ch)) {
                Integer val = tmpMap.get(ch);
                if (val > 1) {
                    tmpMap.merge(ch, 1, (o1, o2) -> o1 - o2);
                } else {
                    tmpMap.remove(ch);
                }
                matches++;
            } else {
                if (matches > 0) {
                    matches = 0;
                    tmpMap = new HashMap<>(map);
                    r = l++;
                }
            }
            if (tmpMap.isEmpty()) {
                out = true;
                break;
            }
            r++;
        }
        return out;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        int len1 = s1.length();
        int len2 = s2.length();
        int a = 'a';

        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - a]++;
            s2Count[s2.charAt(i) - a]++;
        }

        if (Arrays.equals(s1Count, s2Count)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            s2Count[s2.charAt(i) - a]++;
            s2Count[s2.charAt(i - len1) - a]--;
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        return false;
    }
}
