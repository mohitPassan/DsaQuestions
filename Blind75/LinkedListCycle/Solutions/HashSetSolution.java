package Blind75.LinkedListCycle.Solutions;

import java.util.HashSet;
import java.util.Set;

import DataStructures.LinkedList.ListNode;

public class HashSetSolution implements ISolution {
    @Override
    public boolean hasCycle(ListNode head) {
        Set<Integer> codeSet = new HashSet<>();

        ListNode temp = head;
        while (temp != null) {
            if (codeSet.contains(temp.hashCode())) {
                return true;
            } else {
                codeSet.add(temp.hashCode());
            }
            temp = temp.next;
        }

        return false;
    }
}
