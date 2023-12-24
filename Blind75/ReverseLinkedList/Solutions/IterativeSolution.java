package Blind75.ReverseLinkedList.Solutions;

import Blind75.ReverseLinkedList.LinkedList.ListNode;

public class IterativeSolution implements ISolution {
    @Override
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
