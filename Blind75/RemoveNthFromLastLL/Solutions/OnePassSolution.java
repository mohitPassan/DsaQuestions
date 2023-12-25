package Blind75.RemoveNthFromLastLL.Solutions;

import DataStructures.LinkedList.ListNode;

public class OnePassSolution implements ISolution {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        int steps = n;
        while (steps != 0) {
            right = right.next;
            steps--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
