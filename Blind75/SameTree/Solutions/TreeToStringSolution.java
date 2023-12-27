package Blind75.SameTree.Solutions;

import DataStructures.BinaryTree.TreeNode;

public class TreeToStringSolution implements ISolution {
    private String constructTreeString(TreeNode root) {
        if (root == null) {
            String s = new String("null");
            return s;
        }

        String finalString = new String();

        String leftTreeString = constructTreeString(root.left);
        String rightTreeString = constructTreeString(root.right);

        finalString = finalString + "left:" + leftTreeString;
        finalString = finalString + "root:" + root.val;
        finalString = finalString + "right:" + rightTreeString;

        return finalString;
    }

    @Override
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Tree to string.
        String pString = constructTreeString(p);
        String qString = constructTreeString(q);

        return pString.equals(qString);
    }

}