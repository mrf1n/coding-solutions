package com.github.mrf1n;

public class T1342_NumberOfStepsToReduceNumberToZero {

    public static void main(String[] args) {
        int num0 = 14;
        System.out.println(new T1342_NumberOfStepsToReduceNumberToZero().numberOfSteps(num0));
        int num1 = 8;
        System.out.println(new T1342_NumberOfStepsToReduceNumberToZero().numberOfSteps(num1));
        int num2 = 0;
        System.out.println(new T1342_NumberOfStepsToReduceNumberToZero().numberOfStepsLC(num2));
    }

    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }

    public int numberOfStepsLC(int num) {
        int steps = 0;
        while (num > 0) {
            steps++;
            num = ((num & 1) != 0) ? num - 1 : num >> 1;
        }
        return steps;
    }
}
