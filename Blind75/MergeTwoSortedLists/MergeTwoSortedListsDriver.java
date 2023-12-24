package Blind75.MergeTwoSortedLists;

import Blind75.MergeTwoSortedLists.Solutions.ISolution;
import Blind75.MergeTwoSortedLists.Solutions.Solution;
import DataStructures.LinkedList.LinkedList;
import DataStructures.LinkedList.ListNode;

class TestCase {
    LinkedList list1;
    LinkedList list2;

    TestCase(LinkedList list1, LinkedList list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    @Override
    public String toString() {
        return "List1: " + list1.toString() + ", List2: " + list2.toString();
    }
}

public class MergeTwoSortedListsDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new LinkedList(new int[] { 1, 2, 4 }), new LinkedList(new int[] { 1, 3, 4 })),
                new TestCase(new LinkedList(new int[] {}), new LinkedList(new int[] {})),
                new TestCase(new LinkedList(new int[] {}), new LinkedList(new int[] { 0 })),
        };

        ISolution[] solutions = new ISolution[] {
            new Solution()
        };

        for(ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                ListNode result = solution.mergeTwoLists(testCase.list1.head, testCase.list2.head);
                System.out.println("Result: " + LinkedList.printListFromNode(result));
            }
        }
        System.out.println();
    }
}
