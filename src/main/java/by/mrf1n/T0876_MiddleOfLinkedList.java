package by.mrf1n;

import by.mrf1n.common.ListNode;

public class T0876_MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode test01 = new ListNode(1);
        ListNode test02 = new ListNode(1,new ListNode(2));
        ListNode test03 = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode test04 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode test05 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode test06 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5, new ListNode(6))))));
        ListNode test07 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5, new ListNode(6, new ListNode(7)))))));
        ListNode test08 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        ListNode test09 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9)))))))));
        ListNode test10 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        System.out.println(middleNode(test01));
        System.out.println(middleNode(test02));
        System.out.println(middleNode(test03));
        System.out.println(middleNode(test04));
        System.out.println(middleNode(test05));
        System.out.println(middleNode(test06));
        System.out.println(middleNode(test07));
        System.out.println(middleNode(test08));
        System.out.println(middleNode(test09));
        System.out.println(middleNode(test10));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode middle = head, tail = head;
        int i = 1;
        while (tail != null) {
            tail = tail.next;
            if (i <2) {
                i++;
            } else {
                if (middle.next != null) {
                    middle = middle.next;
                }
                i = 1;
            }
        }
        return middle;
    }
}
