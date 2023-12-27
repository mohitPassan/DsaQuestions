# Problem statement

Given the `root` of a binary tree, return _its maximum depth_.

A binary tree's **maximum depth** is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg)

**Input:** root = \[3,9,20,null,null,15,7]
**Output:** 3

**Example 2:**

**Input:** root = \[1,null,2]
**Output:** 2

**Constraints:**

- The number of nodes in the tree is in the range `[0, 104]`.
- `-100 <= Node.val <= 100`

# Recursive DFS solution

We use recursion to find the output. 

1. Find the max depth of the left tree.
2. Find the max depth of the right tree.
3. Find the greater of the two and return it + 1.

The base case will be returning 0 if root is null.

Time complexity: We are traversing all the nodes so `O(n)`
Space complexity: If tree is unbalanced, again `O(n)`

## Code

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftTreeDepth = maxDepth(root.left);
        int rightTreeDepth = maxDepth(root.right);

        return Math.max(leftTreeDepth, rightTreeDepth) + 1;
    }
}
```

# BFS

BFS is mainly level order traversal which uses a queue. First we push the root element in the queue and for the current elements in the queue, we pop the element and push its children.

- Root is the first level and for all elements in the queue, we push its children and increment level.
- Now in the queue there will be the next level, for all the elements in the queue, we repeat the process.
- In the end, we would have traversed all the levels

Time complexity: We are traversing all the nodes so `O(n)`
Space complexity: If tree is unbalanced, again `O(n)

## Code

```java
class Solution {
    public int maxDepth(TreeNode root) {
        // BFS
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            level++;
        }
        
        return level;
    }
}
```

# Iterative DFS

This will be same as the recursive solution we will just be using stack to simulate the call stack. Since, recursion is a stack only, we can use a stack to implement the solution.

In the stack we will be pushing a Pair of <TreeNode, level>.

Whenever we push a child to the stack, we push it as <ChildNode, level + 1>. In the end we will return the maximum level we got.

## Code

```java
class Solution {
    class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int maxDepth(TreeNode root) {
        // Iterative DFS
        if(root == null) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        Pair pair = new Pair(root, 1);
        stack.push(pair);
        int maxLevel = 0;

        while(!stack.isEmpty()) {
            Pair current = stack.pop();
            if(current.node.left != null) {
                Pair newPair = new Pair(current.node.left, current.level + 1);
                stack.push(newPair);
            }

            if(current.node.right != null) {
                Pair newPair = new Pair(current.node.right, current.level + 1);
                stack.push(newPair);
            }

            if(current.level > maxLevel) {
                maxLevel = current.level;
            }
        }

        return maxLevel;
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=hTM3phVI6YQ)
