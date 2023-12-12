# Problem statement

Given a **1-indexed** array of integers `numbers` that is already **_sorted in non-decreasing order_**, find two numbers such that they add up to a specific `target` number. Let these two numbers be `numbers[index1]` and `numbers[index2]` where `1 <= index1 < index2 < numbers.length`.

Return _the indices of the two numbers,_ `index1` _and_ `index2`_, **added by one** as an integer array_ `[index1, index2]` _of length 2._

The tests are generated such that there is **exactly one solution**. You **may not** use the same element twice.

Your solution must use only constant extra space.

**Example 1:**

**Input:** numbers = \[2,7,11,15], target = 9
**Output:** \[1,2]
**Explanation:** The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return \[1, 2].

**Example 2:**

**Input:** numbers = \[2,3,4], target = 6
**Output:** \[1,3]
**Explanation:** The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return \[1, 3].

**Example 3:**

**Input:** numbers = \[-1,0], target = -1
**Output:** \[1,2]
**Explanation:** The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return \[1, 2].

**Constraints:**

- `2 <= numbers.length <= 3 * 104`
- `-1000 <= numbers[i] <= 1000`
- `numbers` is sorted in **non-decreasing order**.
- `-1000 <= target <= 1000`
- The tests are generated such that there is **exactly one solution**.

# Binary searching complementary

Since the array is sorted, we can use binary search to find the `difference` in the remaining array.

Time complexity: `O(nlogn)`

```java
class Solution {
    private int findComplementary(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(numbers[mid] == target) {
                return mid;
            } else if(numbers[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++) {
            int current = numbers[i];
            int difference = target - current;

            int complementaryIndex = findComplementary(Arrays.copyOfRange(numbers, i+1, numbers.length), difference);
            if(complementaryIndex != -1) {
                return new int[] { i+1, complementaryIndex+2+i };
            }
        }

        return new int [] {};
    }
}
```

# Two pointers

We take `l=0 and r=length-1`. We take the sum of the numbers at both pointers and check if it is equal to, greater, or lesser than the target.

- If `sum == k` -> This is the solution, return the indices.
- If `sum > k` -> We need to decrease the sum and since the array is sorted, we will decrement the right pointer.
- If `sum < k` -> We need to increase the sum and since the array is sorted, we will increment the left pointer.

We do this while `l < r`.

Time complexity: `O(n)`

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if(sum == target) {
                return new int[] { l+1, r+1 };
            } else if(sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[] {};
    }
}
```