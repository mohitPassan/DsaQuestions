package Blind75.ReorderList.Solutions;

import DataStructures.LinkedList.ListNode;

public class ArraySolution implements ISolution {
    @Override
    public void reorderList(ListNode head) {
        ListNode n = head;
        int size = 0;

        while (n != null) {
            n = n.next;
            size++;
        }

        ListNode[] nodeArr = new ListNode[size];
        n = head;
        int index = 0;
        while (n != null) {
            nodeArr[index] = n;
            n = n.next;
            index++;
        }

        int i = 0;
        int j = size - 1;
        while (i <= j) {
            if (i == j) {
                nodeArr[i].next = null;
                break;
            }

            nodeArr[i].next = nodeArr[j];

            if (nodeArr[j] == nodeArr[i + 1]) {
                nodeArr[j].next = null;
            } else {
                nodeArr[j].next = nodeArr[i + 1];
            }

            i++;
            j--;
        }
    }
}
