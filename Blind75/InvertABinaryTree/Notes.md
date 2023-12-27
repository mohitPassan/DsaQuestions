# Problem statement

Given the `root` of a binary tree, invert the tree, and return _its root_.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg)

**Input:** root = \[4,2,7,1,3,6,9]
**Output:** \[4,7,2,9,6,3,1]

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg)

**Input:** root = \[2,1,3]
**Output:** \[2,3,1]

**Example 3:**

**Input:** root = []
**Output:** []

**Constraints:**

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

# Recursion

The solution is extremely simple using recursion. 

1. Tell the function to invert the left tree and get the root (`leftInvertedTree`).
2. Tell the function to invert the right tree and get the root (`rightInvertedTree`).
3. Now point the left to the `rightInvertedTree` and right to the `leftInvertedTree`.
4. Done

## Code

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        TreeNode invertedLeftTree = invertTree(root.left);
        TreeNode invertedRightTree = invertTree(root.right);

        root.left = invertedRightTree;
        root.right = invertedLeftTree;

        return root;
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=OnSn2XEQ4MY)

