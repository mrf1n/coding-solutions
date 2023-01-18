package by.mrf1n.common;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + (left != null? left.val: "null") +
                ", right=" + (right != null? right.val: "null") +
                ", next=" + (next != null? next.val: "null") +
                '}';
    }
}
