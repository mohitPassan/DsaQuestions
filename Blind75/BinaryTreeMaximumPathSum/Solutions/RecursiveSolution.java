package Blind75.BinaryTreeMaximumPathSum.Solutions;

import DataStructures.BinaryTree.TreeNode;

public class RecursiveSolution implements ISolution {
    private int maxPathSumHelper(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxPathSumHelper(root.left, max));
        int rightSum = Math.max(0, maxPathSumHelper(root.right, max));

        int currentPathSum = root.val + leftSum + rightSum;
        if(currentPathSum > max[0]) {
            max[0] = currentPathSum;
        }

        return root.val + Math.max(leftSum, rightSum);
    }
    
    @Override
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] { Integer.MIN_VALUE };

        maxPathSumHelper(root, max);

        return max[0];
    }
}
