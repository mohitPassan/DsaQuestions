# Problem statement

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.

Return _the head of the merged linked list_.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg)

**Input:** list1 = \[1,2,4], list2 = \[1,3,4]
**Output:** \[1,1,2,3,4,4]

**Example 2:**

**Input:** list1 = [], list2 = []
**Output:** []

**Example 3:**

**Input:** list1 = [], list2 = \[0]
**Output:** \[0]

**Constraints:**

- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in **non-decreasing** order.

# Solution

We start from the heads of both the lists and keep comparing their values. If one is smaller, connect it as the next node and move the corresponding head.

We first initialise and `finalHead` and a `temp` to maintain the end of the final list. 

1. Find the list which starts from a smaller value and point the head and temp to this list.
2. Start a loop until list1 or list2 becomes null.
3. If `list1.val <= list2.val`, connect the temp's next to list1 and move `list1` further and then move `temp` further. Do the opposite in else condition.

In the end, if any list is left, just connect it to the end of the final list.

## Code

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalHead;
        ListNode temp;

        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        if(list1.val < list2.val) {
            finalHead = list1;
            temp = list1;
            list1 = list1.next;
        } else {
            finalHead = list2;
            temp = list2;
            list2 = list2.next;
        }

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }

        return finalHead;
    }
}
```

# References

![neetCode](https://www.youtube.com/watch?v=XIdigk956u0)

![takeUForward](https://www.youtube.com/watch?v=Xb4slcp1U38)
