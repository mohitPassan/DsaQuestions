# Problem statement

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.

Return `true` _if there is a cycle in the linked list_. Otherwise, return `false`.

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

**Input:** head = \[3,2,0,-4], pos = 1
**Output:** true
**Explanation:** There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

**Example 2:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)

**Input:** head = \[1,2], pos = 0
**Output:** true
**Explanation:** There is a cycle in the linked list, where the tail connects to the 0th node.

**Example 3:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png)

**Input:** head = \[1], pos = -1
**Output:** false
**Explanation:** There is no cycle in the linked list.

**Constraints:**

- The number of the nodes in the list is in the range `[0, 104]`.
- `-105 <= Node.val <= 105`
- `pos` is `-1` or a **valid index** in the linked-list.

**Follow up:** Can you solve it using `O(1)` (i.e. constant) memory?

# Using HashSet

While iterating the linked list, we keep storing the node's `hashCode` in a `HashSet`. If at any point a hash code already exists, that means that we came to this node again and there is a cycle in the list.

Time complexity: `O(n)`
Space complexity: `O(n)`

## Code

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<Integer> codeSet = new HashSet<>();

        ListNode temp = head;
        while(temp != null) {
            if(codeSet.contains(temp.hashCode())) {
                return true;
            } else {
                codeSet.add(temp.hashCode());
            }
            temp = temp.next;
        }

        return false;
    }
}
```

# Using two pointers

We use a fast and a slow pointer. We shift the slow pointer by one step and the fast pointer by two steps. If the fast pointer reaches the end, there is no cycle. If at any point slow pointer becomes equal to the fast pointer, that means that there is a cycle.

This algorithm is also known as **Floyd's Tortoise and Hare algorithm**.

Time complexity: `O(n)`
Space complexity: `O(1)`

## Code

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            if(slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=gBTe7lFR3vc)
- [takeUForward](https://www.youtube.com/watch?v=wiOo4DC5GGA)
