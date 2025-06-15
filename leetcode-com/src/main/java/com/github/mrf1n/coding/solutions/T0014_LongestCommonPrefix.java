package com.github.mrf1n.coding.solutions;

public class T0014_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs0 = new String[]{"flower","flow","flight"};
        System.out.println(new T0014_LongestCommonPrefix().longestCommonPrefix(strs0));
        String[] strs1 = new String[]{"dog","racecar","car" };
        System.out.println(new T0014_LongestCommonPrefix().longestCommonPrefix(strs1));
        String[] strs2 = new String[]{"dog","doger","dogdog"};
        System.out.println(new T0014_LongestCommonPrefix().longestCommonPrefix(strs2));
        String[] strs3 = new String[]{"flow","","flight"};
        System.out.println(new T0014_LongestCommonPrefix().longestCommonPrefix(strs3));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int end = 0;
        boolean isEquals = true;
        while (isEquals) {
            if (strs[0].length() == end) {
                break;
            }
            char current = strs[0].charAt(end);
            for (String str : strs) {
                isEquals = isEquals && str.length() > end && current == str.charAt(end);
            }
            if (isEquals) {
                end++;
            }
        }

        return strs[0].substring(0, end);
    }
}
