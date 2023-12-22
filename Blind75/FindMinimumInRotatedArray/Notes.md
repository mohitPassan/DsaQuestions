# Problem statement

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:

- `[4,5,6,7,0,1,2]` if it was rotated `4` times.
- `[0,1,2,4,5,6,7]` if it was rotated `7` times.

Notice that **rotating** an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of **unique** elements, return _the minimum element of this array_.

You must write an algorithm that runs in `O(log n) time.`

**Example 1:**

**Input:** nums = \[3,4,5,1,2]
**Output:** 1
**Explanation:** The original array was \[1,2,3,4,5] rotated 3 times.

**Example 2:**

**Input:** nums = \[4,5,6,7,0,1,2]
**Output:** 0
**Explanation:** The original array was \[0,1,2,4,5,6,7] and it was rotated 4 times.

**Example 3:**

**Input:** nums = \[11,13,15,17]
**Output:** 11
**Explanation:** The original array was \[11,13,15,17] and it was rotated 4 times. 

**Constraints:**

- `n == nums.length`
- `1 <= n <= 5000`
- `-5000 <= nums[i] <= 5000`
- All the integers of `nums` are **unique**.
- `nums` is sorted and rotated between `1` and `n` times.
# Linear search

We use the same approach that we use in an unsorted array, just go through the array and find the minimum. 

Time complexity: `O(n)`

The interviewer will not be very happy with this solution because the array is sorted and we can do better. We can do `O(logn)`.

## Code

```java
class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int i : nums) {
            if(i < min) {
                 min = i;
            }
        }

        return min;
    }
}
```

# Binary search

Since, the array is sorted (although rotated), we can use binary search to reduce the time. Also, binary search has `O(logn)` time.

The approach is simple, we find which part of the array is sorted, left one or right one. 

1. If left one is sorted, we pick the left most element and continue our search in the right half. 
2. If right one is sorted, we pick the left most element, which is `mid` and continue the search in the left half.

In the end, we will have our minimum element and we just return it.

## Code

```java
class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[start] <= nums[mid]) {
                // Left part is sorted
                if(nums[start] < min) {
                    min = nums[start];
                }
                start = mid + 1;
            } else {
                // Right part is sorted
                if(nums[mid] < min) {
                    min = nums[mid];
                }
                end = mid - 1;
            }
        }

        return min;
    }
}
```
# References

![neetcode](https://www.youtube.com/watch?v=nIVW4P8b1VA)

![takeUForward](https://www.youtube.com/watch?v=nhEMDKMB44g)
