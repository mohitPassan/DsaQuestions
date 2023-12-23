# Problem statement

There is an integer array `nums` sorted in ascending order (with **distinct** values).

Prior to being passed to your function, `nums` is **possibly rotated** at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (**0-indexed**). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

Given the array `nums` **after** the possible rotation and an integer `target`, return _the index of_ `target` _if it is in_ `nums`_, or_ `-1` _if it is not in_ `nums`.

You must write an algorithm with `O(log n)` runtime complexity.

**Example 1:**

**Input:** nums = \[4,5,6,7,0,1,2], target = 0
**Output:** 4

**Example 2:**

**Input:** nums = \[4,5,6,7,0,1,2], target = 3
**Output:** -1

**Example 3:**

**Input:** nums = \[1], target = 0
**Output:** -1

**Constraints:**

- `1 <= nums.length <= 5000`
- `-104 <= nums[i] <= 104`
- All values of `nums` are **unique**.
- `nums` is an ascending array that is possibly rotated.
- `-104 <= target <= 104`

# Linear search

We know how linear search works. Just iterate the array and return the index when element is found.

Time complexity: `O(n)`
## Code

```java
class Solution {
    public int search(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
```

# Binary search

`O(n)` complexity will make the interviewer sad. Since, the array is sorted we can do better. We can get it to `O(logn)` and binary search is an algorithm that works in that time complexity.

The approach is simple:

- Check if the array is sorted (`nums[start] <= nums[end]`). If the whole array is sorted, just do what you do in normal binary search. Compare the target with `nums[mid]` and make the decision.

- If the whole array is not sorted, check if the left part is sorted (`nums[start] <= nums[mid]`). If the left part is sorted, we need to check if our target lies in this part or not. If the target is less than the minimum element in the left part (`nums[start]`) or greater than the maximum element (`nums[mid]`), it lies in the right part, search there otherwise search in the left part.

- If the left part is not sorted, we check if right part is sorted or not and check if target lies here or not using the same technique.
## Code

```java
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[start] < nums[end]) {
                // The whole array is sorted, just do what we do in binary search
                if(target < nums[mid]) {
                    // Find in the left part
                    end = mid - 1;
                    continue;
                } else {
                    // Find in the right part
                    start = mid + 1;
                    continue;
                }
            }

            if(nums[start] <= nums[mid]) {
                // Left part is sorted
                int minInLeft = nums[start];
                int maxInLeft = nums[mid];

                if(target < minInLeft || target > maxInLeft) {
                    // The element is not here, search on the right part
                    start = mid + 1;
                    continue;
                } else {
                    // The element is here, search in the left part
                    end = mid - 1;
                    continue;
                }
            }

            if(nums[mid] <= nums[end]) {
                // Right part is sorted
                int minInRight = nums[mid];
                int maxInRight = nums[end];

                if(target < minInRight || target > maxInRight) {
                    // The element is not here, search on the left part
                    end = mid - 1;
                    continue;
                } else {
                    // The element is here, search in the right part
                    start = mid + 1;
                    continue;
                }
            }
        }

        return -1;
    }
}
```
