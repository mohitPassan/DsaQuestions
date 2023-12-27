Problem statement

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg)

**Input:** p = \[1,2,3], q = \[1,2,3]
**Output:** true

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg)

**Input:** p = \[1,2], q = \[1,null,2]
**Output:** false

**Example 3:**

![](https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg)

**Input:** p = \[1,2,1], q = \[1,1,2]
**Output:** false

**Constraints:**

- The number of nodes in both trees is in the range `[0, 100]`.
- `-104 <= Node.val <= 104`

# Tree to string

We come up with a way to represent our tree in the form of a string. We need to remember to include nulls as well, because position of those matters. Once we have both the strings, we compare them.

## Code

```java
class Solution {
    private String constructTreeString(TreeNode root) {
        if(root == null) {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Tree to string.
        String pString = constructTreeString(p);
        String qString = constructTreeString(q);

        System.out.println(pString);
        System.out.println(qString);

        return pString.equals(qString);
    }
}
```

# Recursion

First we check if the root's values are same or not. If they are not, we return false. Otherwise we we check if left subtrees are same or not and also right subtrees are same or not. If any of the results are false, we return false, otherwise we return true.

Just keep the base cases in mind.

## Code

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Recursion
        if(p == null && q == null) {
            return true;
        }

        if(p == null && q != null) {
            return false;
        }

        if(p != null && q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        boolean leftAnswer = isSameTree(p.left, q.left);
        boolean rightAnswer = isSameTree(p.right, q.right);

        return leftAnswer && rightAnswer;
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=vRbbcKXCxOw)