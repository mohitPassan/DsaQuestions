package Blind75.MaxDepthOfTree;

import Blind75.MaxDepthOfTree.Solutions.BfsSolution;
import Blind75.MaxDepthOfTree.Solutions.ISolution;
import Blind75.MaxDepthOfTree.Solutions.IterativeDfsSolution;
import Blind75.MaxDepthOfTree.Solutions.RecursiveDfsSolution;
import DataStructures.BinaryTree.BinaryTree;

class TestCase {
    BinaryTree tree;

    public TestCase(BinaryTree tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return tree.toString();
    }
}

public class MaxDepthOfTreeDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new BinaryTree(new Integer[] { 3, 9, 20, null, null, 15, 7 })),
                new TestCase(new BinaryTree(new Integer[] { 1, null, 2 })),
                new TestCase(new BinaryTree(
                        new Integer[] { 3, 9, 20, null, null, 15, 7, null, null, null, 8, null, 12, 1, null, 16 })),
                new TestCase(new BinaryTree(new Integer[] { 0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8 })),
        };

        ISolution[] solutions = new ISolution[] {
                new RecursiveDfsSolution(),
                new BfsSolution(),
                new IterativeDfsSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.tree.toString());
                int result = solution.maxDepth(testCase.tree.root);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }

}