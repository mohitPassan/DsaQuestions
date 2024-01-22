# Recursive solution

This is a bit of a hard question and takes some time to understand the solution. We will use recursion to solve this. 

First, we take an extra variable that will be passed around the recursive functions so that we can read and write to this variable. This can be easily done in C++ but Java has its own fucking rules.

At each node, first we will ask from the left tree, the maximum path that is possible without splitting. It's like asking which way should I go if I want to maximise the sum. We ask the same question from the right tree and the maximum path sum.

We are not allowing splitting because we are splitting at the current node we are at. So, you can imagine that we are asking the left tree to give it's path without splitting and also the right tree, without splitting and then we connect the current node in the middle and calculate the path sum that comes out. If this is greater than the maximum, we overwrite it.

What we return from the current node is the maximum of the left or right path plus the current node's value.

## Code

```java
class Solution {
    private int maxPathSumHelper(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxPathSumHelper(root.left, max));
        int rightSum = Math.max(0, maxPathSumHelper(root.right, max));

        int currentPathSum = root.val + leftSum + rightSum;
        if(currentPathSum > max[0]) {
            max[0] = currentPathSum;
        }

        return root.val + Math.max(leftSum, rightSum);
    }
    
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] { Integer.MIN_VALUE };

        int helperAnswer = maxPathSumHelper(root, max);

        return max[0];
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=Hr5cWUld4vU)
- [takeUForward](https://www.youtube.com/watch?v=WszrfSwMz58)
