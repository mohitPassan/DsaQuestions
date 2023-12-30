package Blind75.SubtreeOfAnotherTree.Solutions;

import DataStructures.BinaryTree.TreeNode;

public class RecursiveSolution implements ISolution {
    private boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null && t2 != null) {
            return false;
        }

        if (t1 != null && t2 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        boolean leftAnswer = sameTree(t1.left, t2.left);
        boolean rightAnswer = sameTree(t1.right, t2.right);

        return leftAnswer && rightAnswer;
    }

    @Override
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null && subRoot != null) {
            return false;
        }

        if (root != null && subRoot == null) {
            return false;
        }

        boolean isRootSubtree = sameTree(root, subRoot);

        if (isRootSubtree) {
            return true;
        }

        boolean isLeftSubtree = isSubtree(root.left, subRoot);
        boolean isRightSubtree = isSubtree(root.right, subRoot);

        return isLeftSubtree || isRightSubtree;
    }
}
