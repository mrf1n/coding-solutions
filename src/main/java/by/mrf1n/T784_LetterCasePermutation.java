package by.mrf1n;

import java.util.ArrayList;
import java.util.List;

public class T784_LetterCasePermutation {
    public static void main(String[] args) {
        String str0 = "a1b2";
        System.out.println(new T784_LetterCasePermutation().letterCasePermutation(str0));
    }
    public List<String> letterCasePermutation(String s) {
        List<String> out = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtracking(s, builder, out);
        return out;
    }
    public void backtracking(String s, StringBuilder b, List<String> out) {
        if (b.length() == s.length()) {
            out.add(b.toString());
            return;
        }
        if (Character.isLetter(s.charAt(b.length()))) {
            b.append(Character.toLowerCase(s.charAt(b.length())));
            backtracking(s, b, out);
            b.deleteCharAt(b.length() - 1);
            b.append(Character.toUpperCase(s.charAt(b.length())));
        } else {
            b.append(s.charAt(b.length()));
        }
        backtracking(s, b, out);
        b.deleteCharAt(b.length() - 1);
    }
}
