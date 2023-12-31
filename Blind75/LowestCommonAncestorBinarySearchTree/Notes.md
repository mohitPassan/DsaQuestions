# Problem statement

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**).”

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)

**Input:** root = \[6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
**Output:** 6
**Explanation:** The LCA of nodes 2 and 8 is 6.

**Example 2:**

![](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)

**Input:** root = \[6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
**Output:** 2
**Explanation:** The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

**Example 3:**

**Input:** root = \[2,1], p = 2, q = 1
**Output:** 2

**Constraints:**

- The number of nodes in the tree is in the range `[2, 105]`.
- `-109 <= Node.val <= 109`
- All `Node.val` are **unique**.
- `p != q`
- `p` and `q` will exist in the BST.

# Find the split

In the question given, it is said that a node can be a descendant to itself. So, that means

1. If `p` is a parent of `q`, `p` is the LCA.
2. If `q` is a parent of `p`, `q` is the LCA.

In other cases, we will see if `p` and `q` lie in the left tree or the right tree. 

1. If both of them lie in the left tree, it means that a lower ancestor than `root` definitely exists on the left side. So we make a recursive call on the left tree.
2. If both of them lie in the right side, it means that a lower ancestor than `root` definitely exists on the right side. So we make a recursive call on the right tree.
3. If both of them lie in different sides, that means the root is the LCA.

## Code

```java
class Solution {
    private boolean isParent(TreeNode parent, TreeNode child) {
        if(parent == child) {
            return true;
        }

        if(parent.left == null && parent.right == null) {
            return false;
        }

        if(parent.left != null) {
            boolean isInLeftTree = isParent(parent.left, child);
            if(isInLeftTree) {
                return true;
            }
        }

        if(parent.right != null) {
            boolean isInRightTree = isParent(parent.right, child);
            if(isInRightTree) {
                return true;
            }
        }

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. If q is a child of p, p is the LCA
        boolean isPParentOfQ = isParent(p, q);
        if(isPParentOfQ) {
            return p;
        }

        // 2. If p is a child of q, q is the LCA
        boolean isQParentOfP = isParent(q, p);
        if(isQParentOfP) {
            return q;
        }

        boolean isPInLeft = isParent(root.left, p);
        boolean isPInRight = isParent(root.right, p);
        boolean isQInLeft = isParent(root.left, q);
        boolean isQInRight = isParent(root.right, q);

        if((isPInLeft && isQInRight) || (isPInRight && isQInLeft)) {
            return root;
        }

        if(isPInLeft && isQInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if(isPInRight && isQInRight) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
```

# Find the split (optimised)

Since, this is a binary search tree and not a normal binary tree, we don't really have to traverse the tree to check if the element is in the left or right tree. We can do that by comparing the values. If the value is less, it is in the left sub tree and if the value is more, it is in the right sub tree.

We can also skip checking if `p/q` is a parent of `q/p`, we just check if the `root` is equal to `p` or `q`, it is obvious that root will be the LCA.

## Code

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) {
            return root;
        }

        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }

        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
```

# Root node path

We can use the concept of finding [[Root node path]] in a tree to solve this. Suppose we have the following tree:

![](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)

where, `p = 3` and `q = 5`. Now the root node paths for both of them will be as follows:

1. Root to p: `[6, 2, 4, 3]`
2. Root to q: `[6, 2, 4, 5]`

Now, when we iterate through these paths, as soon as we encounter that the paths differ, we know that the node before was the lca.

## Code

```java
class Solution {
    List<TreeNode> getRootNodePath(TreeNode root, TreeNode node) {
        if(root == null) {
            return null;
        }

        if(root == node) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }

        List<TreeNode> leftPath = getRootNodePath(root.left, node);
        List<TreeNode> rightPath = getRootNodePath(root.right, node);

        if(leftPath == null && rightPath == null) {
            return null;
        }

        if(leftPath == null) {
            rightPath.add(0, root);
            return rightPath;
        }

        if(rightPath == null) {
            leftPath.add(0, root);
            return leftPath;
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Find the root node path to p
        List<TreeNode> rootNodePathToP = getRootNodePath(root, p);

        // Find root node path to q
        List<TreeNode> rootNodePathToQ = getRootNodePath(root, q);

        TreeNode lca = root;
        int size = Math.min(rootNodePathToP.size(), rootNodePathToQ.size());
        for(int i=0; i<size; i++) {
            if(rootNodePathToP.get(i) == rootNodePathToQ.get(i)) {
                lca = rootNodePathToP.get(i);
            } else {
                break;
            }
        }

        return lca;
    }
}
```

# Simple traversal

We can solve this while we traverse the tree. 

Base case: If `root` is null or `p` or `q`, return `root`.

Then we ask for the lca from left and right. If left is null, return right, if right is null, return left and if not any one of them is null, return the root.

## Code

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }

        return root;
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=gs2LMfuOR9k)
- [takeUForward](https://www.youtube.com/watch?v=_-QHfMDde90)
