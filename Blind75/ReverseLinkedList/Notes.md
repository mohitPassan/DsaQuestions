# Problem statement

Given the `head` of a singly linked list, reverse the list, and return _the reversed list_.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)

**Input:** head = \[1,2,3,4,5]
**Output:** \[5,4,3,2,1]

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg)

**Input:** head = \[1,2]
**Output:** \[2,1]

**Example 3:**

**Input:** head = []
**Output:** []

**Constraints:**

- The number of nodes in the list is the range `[0, 5000]`.
- `-5000 <= Node.val <= 5000`

**Follow up:** A linked list can be reversed either iteratively or recursively. Could you implement both?

# Iterative solution

Since we cannot go back in a singly linked list, we need to maintain the references while reversing the list. We need to have three pointers `previous`, `current`, and `next`.

## Code

```java hl:7-12
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
```

# Recursive solution

This is much simpler than the iterative solution. We say the recursive function to reverse the list starting from `head.next`. When we get back the reversed list, we will just link the head to the end of the new list and return the head of the new list.

One thing to pay attention to is that our head's next still has the reference to the last node of the new list, we can use this information to avoid traversing to the end of the new list.

## Code

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }

        if(head.next == null) {
            return head;
        }

        ListNode smallHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return smallHead;
    }
}
```
