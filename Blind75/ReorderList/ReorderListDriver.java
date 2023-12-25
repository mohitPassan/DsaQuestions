package Blind75.ReorderList;

import Blind75.ReorderList.Solutions.ArraySolution;
import Blind75.ReorderList.Solutions.ISolution;
import Blind75.ReorderList.Solutions.InPlaceSolution;
import DataStructures.LinkedList.LinkedList;

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

public class ReorderListDriver {
    public static void main(String[] args) {
        ISolution[] solutions = new ISolution[] {
                new ArraySolution(),
                new InPlaceSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");

            TestCase[] testCases = new TestCase[] {
                    new TestCase(new LinkedList(new int[] { 1, 2, 3, 4 })),
                    new TestCase(new LinkedList(new int[] { 1, 2, 3, 4, 5 }))
            };

            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                solution.reorderList(testCase.list.head);
                System.out.println("Result: " + testCase.list.toString());
            }
            System.out.println();
        }
    }

}