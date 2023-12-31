package Blind75.LowestCommonAncestorBinarySearchTree.Solutions;

import java.util.ArrayList;
import java.util.List;

import DataStructures.BinaryTree.TreeNode;

public class RootNodePathSolution implements ISolution {
    List<TreeNode> getRootNodePath(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }

        if (root == node) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }

        List<TreeNode> leftPath = getRootNodePath(root.left, node);
        List<TreeNode> rightPath = getRootNodePath(root.right, node);

        if (leftPath == null && rightPath == null) {
            return null;
        }

        if (leftPath == null) {
            rightPath.add(0, root);
            return rightPath;
        }

        if (rightPath == null) {
            leftPath.add(0, root);
            return leftPath;
        }

        return null;
    }

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Find the root node path to p
        List<TreeNode> rootNodePathToP = getRootNodePath(root, p);

        // Find root node path to q
        List<TreeNode> rootNodePathToQ = getRootNodePath(root, q);

        TreeNode lca = root;
        int size = Math.min(rootNodePathToP.size(), rootNodePathToQ.size());
        for (int i = 0; i < size; i++) {
            if (rootNodePathToP.get(i) == rootNodePathToQ.get(i)) {
                lca = rootNodePathToP.get(i);
            } else {
                break;
            }
        }

        return lca;
    }
}
