package com.github.mrf1n.coding.solutions;

import com.github.mrf1n.common.ListNode;

import java.util.Stack;

public class T0234_PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println(new T0234_PalindromeLinkedList().isPalindromeOwn(listNode0));
        ListNode listNode1 = new ListNode(1, new ListNode(2));
        System.out.println(new T0234_PalindromeLinkedList().isPalindromeOwn(listNode1));
        ListNode listNode2 = new ListNode(1);
        System.out.println(new T0234_PalindromeLinkedList().isPalindromeOwn(listNode2));
        ListNode listNode3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println(new T0234_PalindromeLinkedList().isPalindromeFastLC(listNode3));
    }

    public boolean isPalindromeOwn(ListNode head) {
        ListNode middle = head, tail = head;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        boolean isPalindrome = true;
        while (tail != null) {
            tail = tail.next;
            if (i % 2 != 0) {
                if (middle.next != null) {
                    stack.push(middle.val);
                    middle = middle.next;
                }
            }
            i++;
        }
        if (i % 2 == 1) {
            middle = middle.next;
        }
        while (!stack.empty() && middle != null) {
            if (middle.val != stack.pop()) {
                isPalindrome = false;
                break;
            }
            middle = middle.next;
        }
        return isPalindrome;
    }

    public boolean isPalindromeFastLC(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
