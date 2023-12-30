# Problem statement

Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of `subRoot` and `false` otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/04/28/subtree1-tree.jpg)

**Input:** root = \[3,4,5,1,2], subRoot = \[4,1,2]
**Output:** true

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/04/28/subtree2-tree.jpg)

**Input:** root = \[3,4,5,1,2,null,null,null,null,0], subRoot = \[4,1,2]
**Output:** false

**Constraints:**

- The number of nodes in the `root` tree is in the range `[1, 2000]`.
- The number of nodes in the `subRoot` tree is in the range `[1, 1000]`.
- `-104 <= root.val <= 104`
- `-104 <= subRoot.val <= 104`

# Recursive solution

Like most tree questions, this one will also be solved using recursion. The basic idea is simple, first we check if the `root` and `subRoot` are same, because a tree is a sub-tree of itself. If this comes out to be true, we return true.

If not, then we check if the left child and subRoot trees are same and also check the right side. If any one of those are same, return true.

To check if the trees are same we use the solution in [[Same tree]] problem.

## Code

```java
class Solution {
    private boolean sameTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }

        if(t1 == null && t2 != null) {
            return false;
        }

        if(t1 != null && t2 == null) {
            return false;
        }

        if(t1.val != t2.val) {
            return false;
        }

        boolean leftAnswer = sameTree(t1.left, t2.left);
        boolean rightAnswer = sameTree(t1.right, t2.right);

        return leftAnswer && rightAnswer;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }

        if(root == null && subRoot != null) {
            return false;
        }

        if(root != null && subRoot == null) {
            return false;
        }

        boolean isRootSubtree = sameTree(root, subRoot);

        if(isRootSubtree) {
            return true;
        }

        boolean isLeftSubtree = isSubtree(root.left, subRoot);
        boolean isRightSubtree = isSubtree(root.right, subRoot);

        return  isLeftSubtree || isRightSubtree;
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=E36O5SWp-LE)
