package Blind75.ReverseLinkedList.Solutions;

import Blind75.ReverseLinkedList.LinkedList.ListNode;

public class RecursiveSolution implements ISolution {
    @Override
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        ListNode smallHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return smallHead;
    }
}
