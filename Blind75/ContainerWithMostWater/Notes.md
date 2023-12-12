# Problem statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return _the maximum amount of water a container can store_.

**Notice** that you may not slant the container.

**Example 1:**

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)

**Input:** height = \[1,8,6,2,5,4,8,3,7]
**Output:** 49
**Explanation:** The above vertical lines are represented by array \[1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

**Example 2:**

**Input:** height = \[1,1]
**Output:** 1git log

**Constraints:**

- `n == height.length`
- `2 <= n <= 105`
- `0 <= height[i] <= 104`

# Nested loops

The brute force way to solve this question is to check each and every line using two nested loops, finding the area between them and checking for maximum area.

Time complexity: `O(n^2)`

TLE

## Code

```java
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        for(int i=0; i<height.length; i++) {
            int h1 = height[i];

            for(int j=i+1; j<height.length; j++) {
                int h2 = height[j];

                int minHeight = Math.min(h1, h2);
                int distance = j-i;
                int area = minHeight * distance;

                if(area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}
```

# Two pointer

We need to maximise the array, so we start from the maximum possible base which are the lines at the end, `0 and length-1`. We find the area, check if it is greater than max area or not.

Since we want to maximise the array, we move forward the pointer which is pointing to the lesser height.

Time complexity: `O(n)`

## Code

```java
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int l = 0;
        int r = height.length - 1;

        while(l<r) {
            int b = r - l;
            int h = Math.min(height[l], height[r]);
            int area = b * h;

            if(area > maxArea) {
                maxArea = area;
            }

            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
```
