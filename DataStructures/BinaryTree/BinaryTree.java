package DataStructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public TreeNode root;

    public enum PrintMethod {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER
    }

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Integer[] arr) {
        int size = arr.length;
        TreeNode root = constructCompleteTree(arr, 0, size);
        this.root = root;
    }

    private TreeNode constructCompleteTree(Integer[] arr, int index, int size) {
        if (index >= size) {
            return null;
        }

        if(arr[index] == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(arr[index]);
        TreeNode leftTree = constructCompleteTree(arr, 2 * index + 1, size);
        TreeNode rightTree = constructCompleteTree(arr, 2 * index + 2, size);
        root.left = leftTree;
        root.right = rightTree;

        return root;
    }

    public void printTree(PrintMethod method) {
        switch (method) {
            case PRE_ORDER:
                BinaryTree.preOrderTraversal(this.root);
                break;

            case IN_ORDER:
                BinaryTree.inOrderTraversal(this.root);
                break;

            case POST_ORDER:
                BinaryTree.postOrderTraversal(this.root);
                break;

            case LEVEL_ORDER:
                BinaryTree.levelOrderTraversal(this.root);
                break;
        }
        System.out.println();
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.peek();
            queue.remove();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    @Override
    public String toString() {
        if (this.root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.peek();
            queue.remove();

            sb.append(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return sb.toString();
    }
}
