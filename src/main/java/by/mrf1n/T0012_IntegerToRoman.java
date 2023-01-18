package by.mrf1n;

public class T0012_IntegerToRoman {
    public static void main(String[] args) {
        int[] tests = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15, 20, 58, 130, 490, 1994, 2890, 3999};
//    int[] test = new int[]{2890,3999};
        for (int test : tests) {
            System.out.println(test + " - " + new T0012_IntegerToRoman().intToRomanIfElse(test));
            System.out.println(test + " - " + new T0012_IntegerToRoman().intToRomanMap(test));
            System.out.println(test + " - " + new T0012_IntegerToRoman().intToRomanMapBest(test));
        }
    }

    public String intToRomanIfElse(int num) {
        String roman = "";
        while (num > 0) {
            if (num >= 1000) {
                roman = roman.concat("M");
                num -= 1000;
            } else if (num >= 900) {
                roman = roman.concat("CM");
                num -= 900;
            } else if (num >= 500) {
                roman = roman.concat("D");
                num -= 500;
            } else if (num >= 400) {
                roman = roman.concat("CD");
                num -= 400;
            } else if (num >= 100) {
                roman = roman.concat("C");
                num -= 100;
            } else if (num >= 90) {
                roman = roman.concat("XC");
                num -= 90;
            } else if (num >= 50) {
                roman = roman.concat("L");
                num -= 50;
            } else if (num >= 40) {
                roman = roman.concat("XL");
                num -= 40;
            } else if (num >= 10) {
                roman = roman.concat("X");
                num -= 10;
            } else if (num == 9) {
                roman = roman.concat("IX");
                num -= 9;
            } else if (num >= 5) {
                roman = roman.concat("V");
                num -= 5;
            } else if (num == 4) {
                roman = roman.concat("IV");
                num -= 4;
            } else if (num == 3) {
                roman = roman.concat("III");
                num -= 3;
            } else if (num == 2) {
                roman = roman.concat("II");
                num -= 2;
            } else {
                roman = roman.concat("I");
                num -= 1;
            }
        }
        return roman;
    }

    public String intToRomanMap(int num) {
        int[] numsMap = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1};
        String[] stringsMap = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "III", "II", "I"};
        String roman = "";
        while (num > 0) {
            for (int i = 0; i < numsMap.length; i++) {
                if (num >= numsMap[i]) {
                    roman = roman.concat(stringsMap[i]);
                    num -= numsMap[i];
                    break;
                }
            }
        }
        return roman;
    }

    public String intToRomanMapBest(int num) {
        int[] numsMap = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1};
        String[] stringsMap = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "III", "II", "I"};
        String roman = "";
        for (int i = 0; i < numsMap.length; i++) {
            while (num >= numsMap[i]) {
                roman = roman.concat(stringsMap[i]);
                num -= numsMap[i];
            }
        }
        return roman;
    }
}
