package Blind75.SubtreeOfAnotherTree;

import Blind75.SubtreeOfAnotherTree.Solutions.ISolution;
import Blind75.SubtreeOfAnotherTree.Solutions.RecursiveSolution;
import DataStructures.BinaryTree.BinaryTree;

class TestCase {
    BinaryTree root;
    BinaryTree subRoot;

    public TestCase(BinaryTree root, BinaryTree subRoot) {
        this.root = root;
        this.subRoot = subRoot;
    }

    @Override
    public String toString() {
        return "root: " + root.toString() + ", subRoot: " + subRoot.toString();
    }
}

public class SubtreeOfAnotherTreeDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(
                        new BinaryTree(new Integer[] { 3, 4, 5, 1, 2 }),
                        new BinaryTree(new Integer[] { 4, 1, 2 })),
                new TestCase(
                        new BinaryTree(new Integer[] { 3, 4, 5, 1, 2, null, null, null, null, 0 }),
                        new BinaryTree(new Integer[] { 4, 1, 2 })),
                new TestCase(
                        new BinaryTree(new Integer[] { 1 }),
                        new BinaryTree(new Integer[] { 0 })),
        };

        ISolution[] solutions = new ISolution[] {
                new RecursiveSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                boolean result = solution.isSubtree(testCase.root.root, testCase.subRoot.root);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}