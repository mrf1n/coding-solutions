package com.github.mrf1n.coding.solutions;

public class T0557_ReverseWords {

    public static void main(String[] args) {
        String s0 = "";
        String s1 = "Dim";
        String s2 = "Dom Dim";
        System.out.println(new T0557_ReverseWords().reverseWords(s0));
        System.out.println(new T0557_ReverseWords().reverseWords(s1));
        System.out.println(new T0557_ReverseWords().reverseWords(s2));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        while (l < chars.length) {
            while (r + 1 < chars.length && chars[r + 1] != ' ') {
                r++;
            }
            int tmpL = l, tmpR = r;
            while (tmpL < tmpR) {
                char tmp = chars[tmpL];
                chars[tmpL] = chars[tmpR];
                chars[tmpR] = tmp;
                tmpL++;
                tmpR--;
            }
            l = r = r + 2;
        }
        return new String(chars);
    }
}
