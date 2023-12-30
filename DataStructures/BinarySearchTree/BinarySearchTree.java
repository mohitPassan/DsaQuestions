package DataStructures.BinarySearchTree;

import DataStructures.BinaryTree.BinaryTree;
import DataStructures.BinaryTree.TreeNode;

public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(Integer[] arr) {
        this.arr = arr;

        for (Integer i : arr) {
            if (i == null) {
                continue;
            }

            this.addNode(i);
        }
    }

    public void addNode(Integer val) {
        if (this.root == null) {
            TreeNode newNode = new TreeNode(val);
            root = newNode;
            return;
        }

        this.root = addNodeHelper(this.root, val);
    }

    private TreeNode addNodeHelper(TreeNode root, Integer val) {
        if (root == null) {
            TreeNode newNode = new TreeNode(val);
            root = newNode;
            return newNode;
        }

        if (val <= root.val) {
            TreeNode leftTree = addNodeHelper(root.left, val);
            root.left = leftTree;
        } else {
            TreeNode rightTree = addNodeHelper(root.right, val);
            root.right = rightTree;
        }

        return root;
    }
}
