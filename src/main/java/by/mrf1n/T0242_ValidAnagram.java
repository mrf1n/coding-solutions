package by.mrf1n;

public class T0242_ValidAnagram {

    public static void main(String[] args) {
        String s0 = "anagram", t0 = "nagaram";
        System.out.println(new T0242_ValidAnagram().isAnagram(s0, t0));
        String s1 = "rat", t1 = "car";
        System.out.println(new T0242_ValidAnagram().isAnagram(s1, t1));
        String s2 = "crat", t2 = "car";
        System.out.println(new T0242_ValidAnagram().isAnagram(s2, t2));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] store = new int[26];
        for (char ch : s.toCharArray()) {
            store[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (--store[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
