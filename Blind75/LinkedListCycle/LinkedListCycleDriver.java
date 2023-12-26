package Blind75.LinkedListCycle;

import Blind75.LinkedListCycle.Solutions.HashSetSolution;
import Blind75.LinkedListCycle.Solutions.ISolution;
import Blind75.LinkedListCycle.Solutions.TortoiseAndHareSolution;
import DataStructures.LinkedList.LinkedList;
import DataStructures.LinkedList.ListNode;

class TestCase {
    LinkedList list;
    String listAsString;
    int pos;

    public TestCase(LinkedList list, int pos) {
        this.list = list;
        this.pos = pos;
        this.listAsString = list.toString();

        if (pos == -1) {
            return;
        }

        ListNode connectionNode = list.head;
        while (pos != 0) {
            connectionNode = connectionNode.next;
            pos--;
        }

        ListNode lastNode = list.head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = connectionNode;
    }

    @Override
    public String toString() {
        return "List: " + listAsString + ", pos: " + pos;
    }
}

public class LinkedListCycleDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new LinkedList(new int[] { 3, 2, 0, -4 }), 1),
                new TestCase(new LinkedList(new int[] { 1, 2 }), 0),
                new TestCase(new LinkedList(new int[] { 1 }), -1),
                new TestCase(new LinkedList(new int[] {}), -1),
        };

        ISolution[] solutions = new ISolution[] {
                new HashSetSolution(),
                new TortoiseAndHareSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Testcase: " + testCase.toString());
                boolean result = solution.hasCycle(testCase.list.head);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}