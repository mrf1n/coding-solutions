package com.github.mrf1n.coding.solutions;

import java.util.Stack;

public class T0020_ValidParentheses {

    public static void main(String[] args) {
        String[] strings0 = new String[]{"", "(", "(()", "(){}", "(}"};
        for (String string : strings0) {
            System.out.println(new T0020_ValidParentheses().isValid(string));
        }
        System.out.println();
        String[] strings1 = new String[]{"", "(", "(()", "(){}", "(}"};
        for (String string : strings1) {
            System.out.println(new T0020_ValidParentheses().isValidSwitch(string));
        }
        System.out.println();
        String[] strings2 = new String[]{"", "(", "(()", "(){}", "(}"};
        for (String string : strings2) {
            System.out.println(new T0020_ValidParentheses().isValidElseIf(string));
        }
        System.out.println();
    }

    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else if (!stack.empty() && Math.abs(bracket - stack.peek()) < 3) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public boolean isValidSwitch(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else if (stack.empty()) {
                return false;
            } else {
                boolean isEndBracket = switch (bracket) {
                    case ')' -> stack.peek() == '(';
                    case ']' -> stack.peek() == '[';
                    case '}' -> stack.peek() == '{';
                    default -> false;
                };

                if (isEndBracket) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public boolean isValidElseIf(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else if (stack.empty()) {
                return false;
            } else if (bracket == ')' && stack.peek() == '('
                    || bracket == ']' && stack.peek() == '['
                    || bracket == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
