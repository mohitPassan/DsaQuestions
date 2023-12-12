# Problem statement

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

**Example 1:**

**Input:** nums = \[-1,0,1,2,-1,-4]
**Output:** \[\[-1,-1,2],\[-1,0,1]]
**Explanation:** 
nums\[0] + nums\[1] + nums\[2] = (-1) + 0 + 1 = 0.
nums\[1] + nums\[2] + nums\[4] = 0 + 1 + (-1) = 0.
nums\[0] + nums\[3] + nums\[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are \[-1,0,1] and \[-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

**Example 2:**

**Input:** nums = \[0,1,1]
**Output:** \[]
**Explanation:** The only possible triplet does not sum up to 0.

**Example 3:**

**Input:** nums = \[0,0,0]
**Output:** \[\[0,0,0]]
**Explanation:** The only possible triplet sums up to 0.

**Constraints:**

- `3 <= nums.length <= 3000`
- `-105 <= nums[i] <= 105`
# 3 nested loops

The brute force solution is to use three nested loops and check for each triplet. If it sums to zero, add it to the result. Store all the groups in a set to avoid duplicates.

Time complexity: `O(n^3)`

This gives TLE on LeetCode.

## Code

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> groups = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(i == j || i == k || j == k) {
                        continue;
                    }

                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> group = new ArrayList<>();
                        group.add(nums[i]);
                        group.add(nums[j]);
                        group.add(nums[k]);

                        Collections.sort(group);
                        groups.add(group);
                    }
                }
            }
        }

        List<List<Integer>> finalGroups = new ArrayList<>(groups);
        return finalGroups;
    }
}
```

# Recursion

Take the first element and pass the rest of the array to the recursive function. There will be two cases:

1. Include the current element and find rest of the groups. So if I wanted 3 numbers, my recursive call will be to find 2 numbers to sum `target - current`.
2. Do not include the current element. My recursive call will be to find 3 numbers which sum to `target`.

Base case: If array length is 0, return empty groups. If array length is 1, find the element in the remaining array using linear search.

In the end, store them in a set to avoid duplicates.

This solution gives TLE on LeetCode.

## Code

```java
class Solution {
    private boolean search(int[] nums, int target) {
        for(int n : nums) {
            if(n == target) {
                return true;
            }
        }
        return false;
    }

    private List<List<Integer>> threeSumHelper(int[] nums, int toFind, int target) {
        List<List<Integer>> groups = new ArrayList<>();

        if(toFind == 1) {
            boolean result = search(nums, target);
            List<Integer> group = new ArrayList<>();

            if(result) {
                group.add(target);
            }

            groups.add(group);

            return groups;
        }

        if(nums.length == 0) {
            return groups;
        }

        int current = nums[0];
        List<List<Integer>> includingCurrent = threeSumHelper(Arrays.copyOfRange(nums, 1, nums.length), toFind-1, target-current);
        List<List<Integer>> excludingCurrent = threeSumHelper(Arrays.copyOfRange(nums, 1, nums.length), toFind, target);
        
        for(List<Integer> g : includingCurrent) {
            if(g.size() != 0) {
                g.add(current);
                groups.add(g);
            }
        }

        for(List<Integer> g : excludingCurrent) {
            if(g.size() != 0) {
                groups.add(g);
            }
        }

        return groups;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> group = new ArrayList<>();
        List<List<Integer>> groups = threeSumHelper(nums, 3, 0);
        Set<List<Integer>> groupSet = new HashSet<>();
        List<List<Integer>> finalGroups = new ArrayList<>();

        for(List<Integer> g : groups) {
            Collections.sort(g);
            groupSet.add(g);
        }
        
        for(List<Integer> g : groupSet) {
            finalGroups.add(g);
        }

        return finalGroups;
    }
}
```

# Sorting + Two pointer (Accepted)

To understand the solution we need to know how to solve [[Two sum]] and [[Two sum II]] because we use the same concepts.

First step is the sort the array `(O(nlogn))`.
Next we iterate through the array and fix the `ith` element as our first element and use two pointer technique we learnt in 'Two sum II' to find other element.

We check if `nums[i] + nums[l] + nums[r] == 0`.

- If `sum < 0`, we increment left pointer.
- If `sum > 0`, we decrement right pointer.
- If `sum == 0`, we increment left pointer and decrement right pointer.

Also, we check if the previous element was the same while incrementing i, l, and decrementing r, to avoid duplicates.

## Code

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> groups = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int current = nums[i];

            int l = i+1;
            int r = nums.length - 1;

            while(l<r) {
                int sum = current + nums[l] + nums[r];

                if(sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    groups.add(Arrays.asList(new Integer[] {current, nums[l], nums[r]}));

                    do {
                        l++;
                    }while(l<r && nums[l] == nums[l-1]);
                    
                    do {
                        r--;
                    }while(l<r && nums[r] == nums[r+1]);
                }
            }
        }

        return groups;
    }
}
```


# Reference

[3SumSolution](https://www.youtube.com/watch?v=DhFh8Kw7ymk)
