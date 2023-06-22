package by.mrf1n;

import by.mrf1n.common.ListNode;

public class T0024_SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new T0024_SwapNodesInPairs().swapPairs(listNode));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode prev = null;

        while (head != null && head.next != null) {
            if (prev != null) {
                prev.next = prev.next.next;
            }
            ListNode swap = head;
            head = head.next;
            swap.next = head.next;
            head.next = swap;
            prev = head.next;
            head = head.next.next;
        }

        return newHead;
    }
}
