package Blind75.LowestCommonAncestorBinarySearchTree.Solutions;

import DataStructures.BinaryTree.TreeNode;

public class FindTheSplitSolution implements ISolution {
    private boolean isParent(TreeNode parent, TreeNode child) {
        if (parent == child) {
            return true;
        }

        if (parent.left == null && parent.right == null) {
            return false;
        }

        if (parent.left != null) {
            boolean isInLeftTree = isParent(parent.left, child);
            if (isInLeftTree) {
                return true;
            }
        }

        if (parent.right != null) {
            boolean isInRightTree = isParent(parent.right, child);
            if (isInRightTree) {
                return true;
            }
        }

        return false;
    }

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. If q is a child of p, p is the LCA
        boolean isPParentOfQ = isParent(p, q);
        if (isPParentOfQ) {
            return p;
        }

        // 2. If p is a child of q, q is the LCA
        boolean isQParentOfP = isParent(q, p);
        if (isQParentOfP) {
            return q;
        }

        boolean isPInLeft = isParent(root.left, p);
        boolean isPInRight = isParent(root.right, p);
        boolean isQInLeft = isParent(root.left, q);
        boolean isQInRight = isParent(root.right, q);

        if ((isPInLeft && isQInRight) || (isPInRight && isQInLeft)) {
            return root;
        }

        if (isPInLeft && isQInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (isPInRight && isQInRight) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
