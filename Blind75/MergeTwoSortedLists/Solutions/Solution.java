package Blind75.MergeTwoSortedLists.Solutions;

import DataStructures.LinkedList.ListNode;

public class Solution implements ISolution {
    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalHead;
        ListNode temp;

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            finalHead = list1;
            temp = list1;
            list1 = list1.next;
        } else {
            finalHead = list2;
            temp = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }

        return finalHead;
    }
}
