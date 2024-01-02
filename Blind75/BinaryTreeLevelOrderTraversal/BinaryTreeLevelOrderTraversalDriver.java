package Blind75.BinaryTreeLevelOrderTraversal;

import Blind75.BinaryTreeLevelOrderTraversal.Solutions.BfsSolution;
import Blind75.BinaryTreeLevelOrderTraversal.Solutions.ISolution;
import DataStructures.BinaryTree.BinaryTree;

import java.util.List;

class TestCase {
    public BinaryTree tree;

    public TestCase(BinaryTree tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return this.tree.toString();
    }
}

public class BinaryTreeLevelOrderTraversalDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new BinaryTree(new Integer[] { 3, 9, 20, null, null, 15, 7 })),
                new TestCase(new BinaryTree(new Integer[] { 1 })),
                new TestCase(new BinaryTree(new Integer[] {})),
        };

        ISolution[] solutions = new ISolution[] {
            new BfsSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                List<List<Integer>> result = solution.levelOrder(testCase.tree.root);
                System.out.println("Result: " + result.toString());
            }
            System.out.println();
        }
    }

}