package by.mrf1n;

public class T9_PalindromeNumber {
    public static void main(String[] args) {
        int test0 = 121;
        int test1 = 1223221;
        int test2 = 1255221;
        int test3 = 1234554321;
        System.out.println(isPalindromeThree(test0));
        System.out.println(isPalindromeThree(test1));
        System.out.println(isPalindromeThree(test2));
        System.out.println(isPalindromeThree(test3));
    }

    public static boolean isPalindromeOne(int x) {
        char[] chars = Integer.toString(x).toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeTwo(int x) {
        String s = Integer.toString(x);
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            System.out.println(i + " " + (i + 1) + " " + (length - i - 1) + " " + (length - i));
            if (!s.substring(i, i + 1).equals(s.substring(length - i - 1, length - i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeThree(int x) {
        if (x < 0)
            return false;
        int temp = x;
        int rem = 0, rev = 0;
        while (x != 0) {
            rem = x % 10;
            rev = (rev * 10) + rem;
            x /= 10;
        }
        return temp == rev;
    }
}
