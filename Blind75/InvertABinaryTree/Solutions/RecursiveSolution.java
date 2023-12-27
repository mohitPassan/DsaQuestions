package Blind75.InvertABinaryTree.Solutions;

import DataStructures.BinaryTree.TreeNode;

public class RecursiveSolution implements ISolution {
    @Override
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode invertedLeftTree = invertTree(root.left);
        TreeNode invertedRightTree = invertTree(root.right);

        root.left = invertedRightTree;
        root.right = invertedLeftTree;

        return root;
    }
}
