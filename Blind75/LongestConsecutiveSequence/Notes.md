# Problem statement

Given an unsorted array of integers `nums`, return _the length of the longest consecutive elements sequence._

You must write an algorithm that runs in `O(n)` time.

**Example 1:**

**Input:** nums = \[100,4,200,1,3,2]
**Output:** 4
**Explanation:** The longest consecutive elements sequence is `[1, 2, 3, 4]`. Therefore its length is 4.

**Example 2:**

**Input:** nums = \[0,3,7,2,5,8,4,6,0,1]
**Output:** 9

**Constraints:**

- `0 <= nums.length <= 105`
- `-109 <= nums[i] <= 109`

# Optimal solution using hashset

First step that we do is store the array is a hashset. We do this because it removes all the duplicates and it also enables searching in constant time.

Let's assume we have the array `[100, 4, 200, 1, 3, 2]` as our test case. The set for this will be `<100, 4, 200, 1, 3, 2>`.

First we have `100`. We check if `99` exists in the set. It doesn't, this means that this is the start of a sequence so we check for `101` in the set. It doesn't exist, so this sequence is of length.

Next we have `4`. We check if `3` exists in the set. It does. We can skip this because `4` is not the start of a sequence.

When we reach `1`, we check for `2`, then for `3`, then for `4` and then for `5`. We find that this sequence is of length four, so we store this.

In the end we return the longest sequence length.

## Code

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        Set<Integer> numSet = new HashSet<>();

        for(int i : nums) {
            numSet.add(i);
        }

        int longestSequence = 1;
        for(int num : numSet) {
            if(numSet.contains(num - 1)) {
                continue;
            } else {
                int s = num + 1;
                int count = 1;
                while(numSet.contains(s)) {
                    count++;
                    s++;
                }
                if(count > longestSequence) {
                    longestSequence = count;
                }
            }
        }

        return longestSequence;
    }
}
```

## Reference

1. [takeUForward](https://www.youtube.com/watch?v=oO5uLE7EUlM)
2. [Neetcode](https://www.youtube.com/watch?v=P6RZZMu_maU)
