# Problem statement

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

**Example 1:**

**Input:** nums = \[1,2,3,1\]
**Output:** true

**Example 2:**

**Input:** nums = \[1,2,3,4\]
**Output:** false

**Example 3:**

**Input:** nums = \[1,1,1,3,3,4,3,2,4,2\]
**Output:** true

# My solution

I used a `HashMap` to solve this. The key is the number and value is the number of times it repeats. Just loop through the array and keep adding the numbers in the map. In each loop check if the number already exists in the map, if it does it means duplicates are there and if the whole array is iterated, it means that there were no duplicates.

## Code

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i : nums) {
            // If the number already exists, return true.
            if(hm.get(i) != null) {
                return true;
            } else {
                hm.put(i, 1);
            }
        }

        // If we are here, it means there were no duplicates
        // so, return false.
        return false;
    }
}
```

# Optimised solution

We use the concept of [[Insertion sort]] to reduce the runtime of the code. What happens is in insertion sort is that the sorted array is built after each iteration. What we do is that after each iteration, when one more element is added to the sorted portion, we check if the adjacent element is the same.

## Code

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            int current = nums[i];

            int j = i-1;
            while(j>=0 && current < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = current;

            if(j >=0 && nums[j] == nums[j+1]) {
                return true;
            }
        }

        return false;
    }
}
```

