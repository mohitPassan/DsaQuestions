package Blind75.MaxDepthOfTree.Solutions;

import java.util.Stack;

import DataStructures.BinaryTree.TreeNode;

public class IterativeDfsSolution implements ISolution {
    class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    @Override
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(root, 1);
        stack.push(pair);
        int maxLevel = 0;

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            if (current.node.left != null) {
                Pair newPair = new Pair(current.node.left, current.level + 1);
                stack.push(newPair);
            }

            if (current.node.right != null) {
                Pair newPair = new Pair(current.node.right, current.level + 1);
                stack.push(newPair);
            }

            if (current.level > maxLevel) {
                maxLevel = current.level;
            }
        }

        return maxLevel;
    }
}
