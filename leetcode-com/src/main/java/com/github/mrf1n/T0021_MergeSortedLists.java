package com.github.mrf1n;

import com.github.mrf1n.common.ListNode;

public class T0021_MergeSortedLists {
    public static void main(String[] args) {
        ListNode listNode01 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(7)))));
        ListNode listNode02 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(8))));
        System.out.println(new T0021_MergeSortedLists().mergeTwoLists(listNode01, listNode02));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode node;
        if (list1.val <= list2.val) {
            node = list1;
            list1 = list1.next;
        } else {
            node = list2;
            list2 = list2.next;
        }
        node.next = mergeTwoLists(list1, list2);
        return node;
    }
}
