package Blind75.RemoveNthFromLastLL;

import Blind75.RemoveNthFromLastLL.Solutions.ISolution;
import Blind75.RemoveNthFromLastLL.Solutions.OnePassSolution;
import Blind75.RemoveNthFromLastLL.Solutions.TwoPassesSolution;
import DataStructures.LinkedList.LinkedList;
import DataStructures.LinkedList.ListNode;

class TestCase {
    LinkedList list;
    int n;

    public TestCase(LinkedList list, int n) {
        this.list = list;
        this.n = n;
    }

    @Override
    public String toString() {
        return "List: " + list.toString() + ", n: " + n;
    }
}

public class RemoveNthFromLastLLDriver {
    public static void main(String[] args) {
        ISolution[] solutions = new ISolution[] {
                new TwoPassesSolution(),
                new OnePassSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            TestCase[] testCases = new TestCase[] {
                    new TestCase(new LinkedList(new int[] { 1, 2, 3, 4, 5 }), 2),
                    new TestCase(new LinkedList(new int[] { 1 }), 1),
                    new TestCase(new LinkedList(new int[] { 1, 2 }), 1),
                    new TestCase(new LinkedList(new int[] { 1, 2 }), 2),
            };

            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                ListNode result = solution.removeNthFromEnd(testCase.list.head, testCase.n);
                System.out.println("Result: " + LinkedList.printListFromNode(result));
            }
            System.out.println();
        }
    }
}
