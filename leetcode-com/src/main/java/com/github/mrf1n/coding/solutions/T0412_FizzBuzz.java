package com.github.mrf1n.coding.solutions;

import java.util.ArrayList;
import java.util.List;

public class T0412_FizzBuzz {

    public static void main(String[] args) {
        System.out.println(new T0412_FizzBuzz().fizzBuzz(5));
        System.out.println(new T0412_FizzBuzz().fizzBuzz(15));
        System.out.println(new T0412_FizzBuzz().fizzBuzzLC(15));
        System.out.println(new T0412_FizzBuzz().fizzBuzzLC(1));
    }

    public List<String> fizzBuzz(int n) {
        List<String> strings = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 15 == 0) {
                strings.add("FizzBuzz");
            } else if (i % 3 == 0) {
                strings.add("Fizz");
            } else if (i % 5 == 0) {
                strings.add("Buzz");
            } else {
                strings.add(String.valueOf(i));
            }
        }
        return strings;
    }

    public List<String> fizzBuzzLC(int n) {
        List<String> strings = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            String currStr = "";
            if (i % 3 == 0) {
                currStr += "Fizz";
            }
            if (i % 5 == 0) {
                currStr += "Buzz";
            }
            if (currStr.isEmpty()) {
                currStr += String.valueOf(i);
            }
            strings.add(currStr);
        }
        return strings;
    }
}
