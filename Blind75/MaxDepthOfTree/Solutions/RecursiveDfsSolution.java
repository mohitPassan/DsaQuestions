package Blind75.MaxDepthOfTree.Solutions;

import DataStructures.BinaryTree.TreeNode;

public class RecursiveDfsSolution implements ISolution {
    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeDepth = maxDepth(root.left);
        int rightTreeDepth = maxDepth(root.right);

        return Math.max(leftTreeDepth, rightTreeDepth) + 1;
    }
}
