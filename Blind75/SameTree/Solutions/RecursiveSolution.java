package Blind75.SameTree.Solutions;

import DataStructures.BinaryTree.TreeNode;

public class RecursiveSolution implements ISolution {
    @Override
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean leftAnswer = isSameTree(p.left, q.left);
        boolean rightAnswer = isSameTree(p.right, q.right);

        return leftAnswer && rightAnswer;
    }

}