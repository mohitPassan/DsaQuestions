package Blind75.BinaryTreeMaximumPathSum;

import Blind75.BinaryTreeMaximumPathSum.Solutions.ISolution;
import Blind75.BinaryTreeMaximumPathSum.Solutions.RecursiveSolution;
import DataStructures.BinaryTree.BinaryTree;

class TestCase {
    BinaryTree tree;

    public TestCase(BinaryTree tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return this.tree.toString();
    }
}

public class BinaryTreeMaximumPathSumDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase(new BinaryTree(new Integer[] {1, 2, 3})),
            new TestCase(new BinaryTree(new Integer[] {-10,9,20,null,null,15,7})),
            new TestCase(new BinaryTree(new Integer[] {-3})),
        };

        ISolution[] solutions = new ISolution[] {
            new RecursiveSolution()
        };

        for(ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int result = solution.maxPathSum(testCase.tree.root);
                System.out.println("Result: " + result);
            }
        }
    }

}
