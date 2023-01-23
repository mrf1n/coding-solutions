package by.mrf1n;

import java.util.Stack;

public class T0155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.pop();
        minStack.push(-3);
    }


    static class MinStack {

        private final Stack<int[]> st;

        public MinStack() {
            st = new Stack<>();
        }

        public void push(int val) {
            if (!st.isEmpty()) {
                int[] top = st.peek();
                int min = Math.min(top[1], val);
                st.push(new int[]{val, min});
            } else {
                st.push(new int[]{val, val});
            }
        }

        public void pop() {
            if (!st.isEmpty())
                st.pop();
        }

        public int top() {
            int[] top = st.peek();
            return top[0];
        }

        public int getMin() {
            int[] min = st.peek();
            return min[1];
        }
    }
}
