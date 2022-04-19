package by.mrf1n;

import by.mrf1n.common.ListNode;

public class T206_ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new T206_ReverseLinkedList().reverseList(listNode0));
        ListNode listNode1 = new ListNode(1, new ListNode(2));
        System.out.println(new T206_ReverseLinkedList().reverseList(listNode1));
        ListNode listNode2 = new ListNode(1);
        System.out.println(new T206_ReverseLinkedList().reverseList(listNode2));
        ListNode listNode3 = null;
        System.out.println(new T206_ReverseLinkedList().reverseList(listNode3));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode nextNode = newHead;
        if (head.next.next != null) {
            nextNode = reverseList(head.next);
        }
        head.next = null;
        newHead.next = head;
        newHead = nextNode;
        return newHead;
    }
}
