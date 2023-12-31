package Blind75.LowestCommonAncestorBinarySearchTree;

import java.util.Arrays;

import Blind75.LowestCommonAncestorBinarySearchTree.Solutions.FindTheSplitOptimizedSolution;
import Blind75.LowestCommonAncestorBinarySearchTree.Solutions.FindTheSplitSolution;
import Blind75.LowestCommonAncestorBinarySearchTree.Solutions.ISolution;
import Blind75.LowestCommonAncestorBinarySearchTree.Solutions.RootNodePathSolution;
import Blind75.LowestCommonAncestorBinarySearchTree.Solutions.SimpleTraversalSolution;
import DataStructures.BinarySearchTree.BinarySearchTree;
import DataStructures.BinaryTree.TreeNode;

class BinarySearchTreeExtended extends BinarySearchTree {
    private TreeNode addNodeHelper(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        if (node.val < root.val) {
            TreeNode leftTree = addNodeHelper(root.left, node);
            root.left = leftTree;
        }

        if (node.val > root.val) {
            TreeNode rightTree = addNodeHelper(root.right, node);
            root.right = rightTree;
        }

        return root;
    }

    public void addNode(TreeNode node) {
        if (this.root == null) {
            this.root = node;
            return;
        }

        this.root = addNodeHelper(this.root, node);
    }
}

class TestCase {
    BinarySearchTreeExtended tree;
    TreeNode p;
    TreeNode q;
    Integer[] arr;

    public TestCase(Integer[] arr, int p, int q) {
        this.tree = new BinarySearchTreeExtended();
        this.arr = arr;

        for (Integer i : arr) {
            if (i == null) {
                continue;
            }

            TreeNode newNode = new TreeNode(i);
            this.tree.addNode(newNode);

            if (i == p) {
                this.p = newNode;
            }

            if (i == q) {
                this.q = newNode;
            }
        }
    }

    @Override
    public String toString() {
        return "\nRoot: " + Arrays.toString(arr) + "\np: " + p.val + "\nq: " + q.val;
    }
}

public class LowestCommonAncestorBinarySearchTreeDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 }, 2, 8),
                new TestCase(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 }, 2, 4),
                new TestCase(new Integer[] { 2, 1 }, 2, 1),
                new TestCase(new Integer[] { 2, null, 3 }, 2, 3)
        };

        ISolution[] solutions = new ISolution[] {
                new FindTheSplitSolution(),
                new FindTheSplitOptimizedSolution(),
                new RootNodePathSolution(),
                new SimpleTraversalSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case:" + testCase.toString());
                TreeNode result = solution.lowestCommonAncestor(testCase.tree.root,
                        testCase.p, testCase.q);
                System.out.println("Result: " + result.val);
            }
            System.out.println();
        }
    }
}
