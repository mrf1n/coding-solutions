package com.github.mrf1n.coding.solutions;

import java.util.HashMap;
import java.util.Map;

public class T0013_RomanToInteger {

    public static void main(String[] args) {
        String s0 = "III";
        System.out.println(new T0013_RomanToInteger().romanToInt(s0));
        String s1 = "LVIII";
        System.out.println(new T0013_RomanToInteger().romanToIntMap(s1));
        String s2 = "MCMXCIV";
        System.out.println(new T0013_RomanToInteger().romanToInt(s2));
    }

    public int romanToInt(String s) {
        int answer = 0, number = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }

        return answer;
    }

    public int romanToIntMap(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int prev = 0;
        int x = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (prev > map.get(s.charAt(i))) {
                x -= map.get(s.charAt(i));
            } else {
                x += map.get(s.charAt(i));
            }
            prev = map.get(s.charAt(i));
        }

        return x;
    }
}
