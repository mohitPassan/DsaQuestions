# Problem statement

Given the `head` of a linked list, remove the `nth` node from the end of the list and return its head.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg)

**Input:** head = \[1,2,3,4,5], n = 2
**Output:** \[1,2,3,5]

**Example 2:**

**Input:** head = \[1], n = 1
**Output:** []

**Example 3:**

**Input:** head = \[1,2], n = 1
**Output:** \[1]

**Constraints:**

- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

**Follow up:** Could you do this in one pass?

# Find size

The intuitive approach is really simple. Find the size of the list by iterating the list once and finding the index to be deleted, from the beginning. Knowing which element to delete from the beginning of the list is really simple.

Time complexity: `O(2n)`
Space complexity: `O(n)`

## Code

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Get the size of the array
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        // Get the required element
        int indexFromStart = size - n;

        if(indexFromStart == 0) {
            // Delete the first element
            head = head.next;
            return head;
        } else if(indexFromStart == (size - 1)) {
            temp = head;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            return head;
        } else {
            temp = head;
            ListNode oneBefore = null;
            while(indexFromStart != 0) {
                oneBefore = temp;
                temp = temp.next;
                indexFromStart--;
            }

            // Now delete the element at temp
            oneBefore.next = temp.next;
            return head;
        }
    }
}
```

# Two pointers

First attach a dummy node to the start of the list to avoid the test case of removing the first node. 

1. Initialise the left pointer from the dummy node and right pointer from the head.
2. Shift the right pointer by `n` steps. This will create an offset of `n` between left and right.
3. Now move both the pointers one by one until right reaches null.
4. When right is null, our left pointer will be just one before the node to be deleted.

Delete that bitch!

## Code

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        int steps = n;
        while(steps != 0) {
            right = right.next;
            steps--;
        }

        while(right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
```

# References

- [neetCode](https://www.youtube.com/watch?v=XVuQxVej6y8)
- [takeUForward](https://www.youtube.com/watch?v=3kMKYQ2wNIU)
