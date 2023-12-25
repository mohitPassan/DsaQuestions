# Problem statement

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

_Reorder the list to be on the following form:_

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/04/reorder1linked-list.jpg)

**Input:** head = \[1,2,3,4]
**Output:** \[1,4,2,3]

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/09/reorder2-linked-list.jpg)

**Input:** head = \[1,2,3,4,5]
**Output:** \[1,5,2,4,3]

**Constraints:**

- The number of nodes in the list is in the range `[1, 5 * 104]`.
- `1 <= Node.val <= 1000`


# Solution using array

Just imagine if we had to reorder an array. We would take two pointers `i = 0` and `j = arr.length - 1`. We would just simply create a new array and put `ith element` and then increment `i` and then put `jth element` and decrement it and keep doing this.

Now, what we do is that store each and every node from the linked list in an array, then take two pointers in the beginning and end. Then we connect the `ith element` with the `jth element` and connect the `jth element` with the `i+1th element`. We increment `i` and decrement `j` and keep doing this.

Time complexity: `O(n)`
Space complexity: `O(n)

## Code

```java
class Solution {
    public void reorderList(ListNode head) {
        ListNode n = head;
        int size = 0;

        while(n != null) {
            n = n.next;
            size++;
        }

        ListNode[] nodeArr = new ListNode[size];
        n = head;
        int index = 0;
        while(n != null) {
            nodeArr[index] = n;
            n = n.next;
            index++;
        }

        int i=0;
        int j=size-1;
        while(i <= j) {
            if(i == j) {
                nodeArr[i].next = null;
                break;
            }
            
            nodeArr[i].next = nodeArr[j];

            if(nodeArr[j] == nodeArr[i+1]) {
                nodeArr[j].next = null;
            } else {
                nodeArr[j].next = nodeArr[i+1];
            }

            i++;
            j--;
        }
    }
}
```

# In place solution

This solution will use three concepts of linked list algorithms:

1. Find mid element
2. Reversing a linked list
3. Merging two lists

First, we break the main list in two lists by finding the mid element. Then, we reverse the second half. Finally, we merge the two lists as required.

## Code

```java
class Solution {
    public void reorderList(ListNode head) {
        // 1. Find the mid of the list
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;

        // 2. Reverse the second list
        ListNode prev = null;
        ListNode current = second;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second = prev;

        // 3. Merge the two lists
        while(second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
}
```

# References

- [NeetCode](https://www.youtube.com/watch?v=S5bfdUTrKLM)