package com.github.mrf1n;

import com.github.mrf1n.common.ListNode;

public class T0002_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode ln01 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode ln02 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(new T0002_AddTwoNumbers().addTwoNumbers(ln01, ln02));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tmpLN = null;
        int val = 0;
        while (l1 != null || l2 != null || val == 1) {
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            ListNode ln = new ListNode(val % 10);
            val /= 10;
            if (head == null) {
                head = tmpLN = ln;
            } else {
                tmpLN = tmpLN.next = ln;
            }
        }
        return head;
    }
}
