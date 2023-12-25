package Blind75.ReorderList.Solutions;

import DataStructures.LinkedList.ListNode;

public class InPlaceSolution implements ISolution {
    @Override
    public void reorderList(ListNode head) {
        // 1. Find the mid of the list
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;

        // 2. Reverse the second list
        ListNode prev = null;
        ListNode current = second;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second = prev;

        // 3. Merge the two lists
        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
}
