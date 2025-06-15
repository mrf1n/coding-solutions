package com.github.mrf1n.coding.solutions;

import com.github.mrf1n.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class T0141_LinkedListCycle {

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1, new ListNode(2, new ListNode(3)));
        listNode0.next.next.next = listNode0.next;
        System.out.println(new T0141_LinkedListCycle().hasCycle(listNode0));
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(new T0141_LinkedListCycle().hasCycle(listNode1));

        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        listNode2.next.next.next = listNode2.next;
        System.out.println(new T0141_LinkedListCycle().hasCycleWithPos(listNode2));
        ListNode listNode3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(new T0141_LinkedListCycle().hasCycleWithPos(listNode3));

        ListNode listNode4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        listNode4.next.next.next = listNode4.next;
        System.out.println(new T0141_LinkedListCycle().hasCycleLC(listNode4));
        ListNode listNode5 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(new T0141_LinkedListCycle().hasCycleLC(listNode5));
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set =  new HashSet<>();
        ListNode ptr = head;
        while (ptr != null && !set.contains(ptr)) {
            set.add(ptr);
            ptr = ptr.next;
            if (set.contains(ptr)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleWithPos(ListNode head) {
        Set<ListNode> set =  new HashSet<>();
        ListNode cycle = head;
        int pos = -1;
        while (cycle != null && !set.contains(cycle)) {
            set.add(cycle);
            cycle = cycle.next;
            if (set.contains(cycle)) {
                ListNode ptr = head;
                pos++;
                while (ptr != cycle) {
                    ptr = ptr.next;
                    pos++;
                }
                break;
            }
        }
        System.out.println(pos);
        return pos != -1;
    }

    public boolean hasCycleLC(ListNode head) {
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;

            if (head == fast)
                return true;
        }

        return false;
    }
}
