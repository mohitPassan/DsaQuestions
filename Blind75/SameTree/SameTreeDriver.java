package Blind75.SameTree;

import Blind75.SameTree.Solutions.ISolution;
import Blind75.SameTree.Solutions.RecursiveSolution;
import Blind75.SameTree.Solutions.TreeToStringSolution;
import DataStructures.BinaryTree.BinaryTree;

class TestCase {
    BinaryTree p;
    BinaryTree q;

    public TestCase(BinaryTree p, BinaryTree q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public String toString() {
        return "p: " + p.toString() + ", " + "q: " + q.toString();
    }
}

public class SameTreeDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(
                        new BinaryTree(new Integer[] { 1, 2, 3 }),
                        new BinaryTree(new Integer[] { 1, 2, 3 })),
                new TestCase(
                        new BinaryTree(new Integer[] { 1, 2 }),
                        new BinaryTree(new Integer[] { 1, null, 2 })),
                new TestCase(
                        new BinaryTree(new Integer[] { 1, 2, 1 }),
                        new BinaryTree(new Integer[] { 1, 1, 2 })),
                new TestCase(
                        new BinaryTree(new Integer[] { 1, 1 }),
                        new BinaryTree(new Integer[] { 1, null, 1 })),
                new TestCase(
                        new BinaryTree(new Integer[] {}),
                        new BinaryTree(new Integer[] { 1, null, 1 })),
        };

        ISolution[] solutions = new ISolution[] {
            new TreeToStringSolution(),
            new RecursiveSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                boolean result = solution.isSameTree(testCase.p.root, testCase.q.root);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }

}