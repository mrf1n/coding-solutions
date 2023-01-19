package by.mrf1n;

public class T0008_StringToInteger {

    public static void main(String[] args) {

        String s0 = "42";
        System.out.println(new T0008_StringToInteger().myAtoi(s0));
        String s1 = "   -42";
        System.out.println(new T0008_StringToInteger().myAtoi(s1));
        String s2 = "4193 with words";
        System.out.println(new T0008_StringToInteger().myAtoi(s2));
        String s3 = "-91283472332";
        System.out.println(new T0008_StringToInteger().myAtoi(s3));
        String s4 = "2147483648";
        System.out.println(new T0008_StringToInteger().myAtoi(s4));
    }

    public int myAtoi(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int index = 0;
        boolean isNegative = false;
        int integer = 0;
        while (!isStart(s.charAt(index))) {
            if (s.charAt(index) != ' ') {
                return 0;
            }
            index++;
            if (index > s.length() - 1) {
                return 0;
            }
        }
        if (isSign(s.charAt(index))) {
            isNegative = s.charAt(index) == '-';
            index++;
        }

        while (index < s.length() && isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (integer > Integer.MAX_VALUE / 10) {
                integer = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                isNegative = false;
                break;
            } else if (!isNegative && integer == Integer.MAX_VALUE / 10 && digit > 6) {
                integer = Integer.MAX_VALUE;
                break;
            } else if (isNegative && integer == Integer.MAX_VALUE / 10 && digit > 7) {
                integer = Integer.MIN_VALUE;
                isNegative = false;
                break;
            } else {
                integer = integer * 10 + digit;
                index++;
            }
        }

        return isNegative ? -1 * integer : integer;
    }

    public boolean isStart(char c) {
        return isSign(c) || isDigit(c);
    }

    public boolean isSign(char c) {
        return c == '-' || c == '+';
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
