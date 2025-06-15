package com.github.mrf1n.coding.solutions;

import com.github.mrf1n.common.ListNode;

public class T0237_DeleteNodeInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        System.out.println(head);
        new T0237_DeleteNodeInLinkedList().deleteNode(head.next);
        System.out.println(head);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
