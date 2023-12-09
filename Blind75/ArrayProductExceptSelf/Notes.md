# Problem statement

Given an integer array `nums`, return _an array_ `answer` _such that_ `answer[i]` _is equal to the product of all the elements of_ `nums` _except_ `nums[i]`.

The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

**Example 1:**

**Input:** nums = [1,2,3,4]
**Output:** [24,12,8,6]

**Example 2:**

**Input:** nums = [-1,1,0,-3,3]
**Output:** [0,0,9,0,0]

**Constraints:**

- `2 <= nums.length <= 105`
- `-30 <= nums[i] <= 30`
- The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

# Brute force

Brute force solution is very simple, just run two loops and find the product. If `i == j -> continue`.

Time complexity: `O(n^2)`
## Code

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] output = new int[size];

        for(int i=0; i<size; i++) {
            int product = 1;
            for(int j=0; j<size; j++) {
                if(i == j) {
                    continue;
                }

                product = nums[j] * product;
            }
            output[i] = product;
        }

        return output;
    }
}
```

# Prefix and suffix product

We create two additional arrays which stores the prefix product and suffix product. The prefix product is the product of all elements that comes before (excluding self). A suffix product is the product of all elements that comes after (excluding self). Then we create our output array by multiplying the prefix and suffix products.

Suppose the test case is `[1, 2, 3, 4]`
The prefix product will be `[1, 1, 2, 6]`
The suffix product will be `[24, 12, 4, 1]`

As you can see for index 2, the prefix product array gives us the product of indices `0 and 1` and the suffix product array gives us the product of index `3`. After multiplying these two, we get the product of indices `0, 1, and 3`, which is the required result.

Time complexity: `O(n)`
Space complexity: `O(n)`

## Code

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] output = new int[size];

        // Prefix product
        int[] prefixProduct = new int[size];
        prefixProduct[0] = 1;
        for(int i=1; i<size; i++) {
            prefixProduct[i] = nums[i-1] * prefixProduct[i-1];
        }

        // Suffix product
        int[] suffixProduct = new int[size];
        suffixProduct[size-1] = 1;
        for(int i=size-2; i>=0; i--) {
            suffixProduct[i] = nums[i+1] * suffixProduct[i+1];
        }

        for(int i=0; i<size; i++) {
            output[i] = prefixProduct[i] * suffixProduct[i];
        }

        return output;
    }
}
```
