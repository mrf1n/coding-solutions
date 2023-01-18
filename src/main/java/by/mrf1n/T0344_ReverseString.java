package by.mrf1n;

public class T0344_ReverseString {
    public static void main(String[] args) {
        char[] chars0 = new char[]{'h','e','l','l','o'};
        new T0344_ReverseString().reverseString(chars0);
        System.out.println(chars0);
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
