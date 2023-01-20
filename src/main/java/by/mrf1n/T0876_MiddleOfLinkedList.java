package by.mrf1n;

import by.mrf1n.common.ListNode;

public class T0876_MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode test01 = new ListNode(1);
        ListNode test02 = new ListNode(1, new ListNode(2));
        ListNode test03 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode test04 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode test05 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode test06 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode test07 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode test08 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        ListNode test09 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9)))))))));
        ListNode test10 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test01));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test02));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test03));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test04));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test05));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test06));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test07));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test08));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test09));
        System.out.println(new T0876_MiddleOfLinkedList().middleNode(test10));
    }

    public ListNode middleNode(ListNode head) {
        ListNode middle = head, tail = head;
        int i = 0;
        while (tail != null) {
            tail = tail.next;
            if (i % 2 != 0) {
                if (middle.next != null) {
                    middle = middle.next;
                }
            }
            i++;
        }
        return middle;
    }
}
