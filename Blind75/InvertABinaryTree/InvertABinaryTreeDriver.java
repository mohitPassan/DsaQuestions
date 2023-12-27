package Blind75.InvertABinaryTree;

import Blind75.InvertABinaryTree.Solutions.ISolution;
import Blind75.InvertABinaryTree.Solutions.RecursiveSolution;
import DataStructures.BinaryTree.BinaryTree;
import DataStructures.BinaryTree.TreeNode;

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

public class InvertABinaryTreeDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new BinaryTree(new Integer[] { 4, 2, 7, 1, 3, 6, 9 })),
                new TestCase(new BinaryTree(new Integer[] { 2, 1, 3 })),
                new TestCase(new BinaryTree(new Integer[] {}))
        };

        ISolution[] solutions = new ISolution[] {
                new RecursiveSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.tree.toString());
                TreeNode result = solution.invertTree(testCase.tree.root);
                System.out.print("Result: ");
                BinaryTree.levelOrderTraversal(result);
                System.out.println();
            }
            System.out.println();
        }
    }
}