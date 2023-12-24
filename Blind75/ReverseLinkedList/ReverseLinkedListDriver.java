package Blind75.ReverseLinkedList;

import Blind75.ReverseLinkedList.LinkedList.LinkedList;
import Blind75.ReverseLinkedList.LinkedList.ListNode;
import Blind75.ReverseLinkedList.Solutions.ISolution;
import Blind75.ReverseLinkedList.Solutions.IterativeSolution;
import Blind75.ReverseLinkedList.Solutions.RecursiveSolution;

class TestCase {
    LinkedList list;

    public TestCase(LinkedList list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

public class ReverseLinkedListDriver {
    public static void main(String[] args) {

        ISolution[] solutions = new ISolution[] {
                new IterativeSolution(),
                new RecursiveSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            
            LinkedList l1 = new LinkedList();
            for (int i : new int[] { 1, 2, 3, 4, 5 }) {
                l1.addNode(i);
            }

            LinkedList l2 = new LinkedList();
            for (int i : new int[] { 1, 2 }) {
                l2.addNode(i);
            }

            LinkedList l3 = new LinkedList();

            TestCase[] testCases = new TestCase[] {
                    new TestCase(l1),
                    new TestCase(l2),
                    new TestCase(l3),
            };

            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                ListNode result = solution.reverseList(testCase.list.head);

                StringBuilder sb = new StringBuilder();
                ListNode n = result;

                if (n == null) {
                    sb.append("[]");
                } else {
                    sb.append("[ ");
                    while (n.next != null) {
                        sb.append(n.val + " -> ");
                        n = n.next;
                    }
                    sb.append(n.val + " ]");
                }

                System.out.println("Result: " + sb.toString());
            }
            System.out.println();
        }
    }

}