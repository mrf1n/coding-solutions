package by.mrf1n;

import by.mrf1n.common.ListNode;

public class T0019_RemoveNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode test01 = new ListNode(1);
        ListNode test02 = new ListNode(1, new ListNode(2));
        ListNode test03 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode test04 = new ListNode(1, new ListNode(-2, new ListNode(3, new ListNode(4))));
        ListNode test05 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(test01, 1));
        System.out.println(removeNthFromEnd(test02, 2));
        System.out.println(removeNthFromEnd(test03, 3));
        System.out.println(removeNthFromEnd(test04, 2));
        System.out.println(removeNthFromEnd(test05, 5));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head, preDelete = null;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        if (node != null) {
            preDelete = head;
            node = node.next;
        }
        while (node != null) {
            node = node.next;
            preDelete = preDelete.next;
        }
        if (preDelete == null) {
            head = head.next;
        } else if (preDelete.next != null) {
            preDelete.next = preDelete.next.next;
        }
        return head;
    }
}
