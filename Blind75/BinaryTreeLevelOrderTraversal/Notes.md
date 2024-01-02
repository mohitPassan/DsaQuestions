# Problem statement

Given the `root` of a binary tree, return _the level order traversal of its nodes' values_. (i.e., from left to right, level by level).

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg)

**Input:** root = \[3,9,20,null,null,15,7]
**Output:** \[\[3],\[9,20],\[15,7]]

**Example 2:**

**Input:** root = \[1]
**Output:** \[\[1]]

**Example 3:**

**Input:** root = \[]
**Output:** \[]

**Constraints:**

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-1000 <= Node.val <= 1000`

# Breadth first search

A simple BFS is simple, but in this question we need to print the elements level wise. So instead of taking element one by one from the queue, we loop through all the elements present in the queue at a given point and process them and add their children.

## Code

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();

        if(root == null) {
            return levels;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            levels.add(new ArrayList<Integer>(level));
            level.clear();
        }

        return levels;
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=6ZnyEApgFYg)
