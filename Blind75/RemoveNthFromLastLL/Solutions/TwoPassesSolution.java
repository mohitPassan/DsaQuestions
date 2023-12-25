package Blind75.RemoveNthFromLastLL.Solutions;

import DataStructures.LinkedList.ListNode;

public class TwoPassesSolution implements ISolution {
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Get the size of the array
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Get the required element
        int indexFromStart = size - n;

        if (indexFromStart == 0) {
            // Delete the first element
            head = head.next;
            return head;
        } else if (indexFromStart == (size - 1)) {
            temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            return head;
        } else {
            temp = head;
            ListNode oneBefore = null;
            while (indexFromStart != 0) {
                oneBefore = temp;
                temp = temp.next;
                indexFromStart--;
            }

            // Now delete the element at temp
            oneBefore.next = temp.next;
            return head;
        }
    }
}
