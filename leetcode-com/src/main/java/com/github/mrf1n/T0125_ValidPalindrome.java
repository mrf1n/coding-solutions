package com.github.mrf1n;

public class T0125_ValidPalindrome {

    public static void main(String[] args) {
        String s0 = "A man, a plan, a canal: Panama";
        System.out.println(new T0125_ValidPalindrome().isPalindrome(s0));
        String s1 = "race a car";
        System.out.println(new T0125_ValidPalindrome().isPalindrome(s1));
        String s2 = " ";
        System.out.println(new T0125_ValidPalindrome().isPalindrome(s2));
        String s3 = "0P";
        System.out.println(new T0125_ValidPalindrome().isPalindrome(s3));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < s.length() - 1 && isNonAlphanumeric(s.charAt(l))) {
                l++;
            }
            System.out.println(l);
            while (r > 0 && isNonAlphanumeric(s.charAt(r))) {
                r--;
            }
            System.out.println(r);
            if (l < r && s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isNonAlphanumeric(char c) {
        return (c < 'a' || c > 'z')
                && (c < '0' || c > '9');
    }
}
