# Problem statement

Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.

**Example 1:**

**Input:** nums = \[2,7,11,15], target = 9
**Output:** \[0,1]
**Explanation:** Because nums\[0] + nums\[1] == 9, we return \[0, 1].

**Example 2:**

**Input:** nums = \[3,2,4], target = 6
**Output:** \[1,2]

**Example 3:**

**Input:** nums = \[3,3], target = 6
**Output:** \[0,1]

**Constraints:**

- `2 <= nums.length <= 104`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`
- **Only one valid answer exists.**

# Brute force

Start a loop from `i=0` and start another loop from `j=i+1`. As soon as you find that `nums[i] + nums[j] == target`, return the values of `i` and `j`.

Time complexity: Since, we are running two nested loops and for each index we iterate the remaining array, the complexity comes out to be `O(n^2)`.

## Code

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0,0};
    }
}
```

# Sorting and searching

**Step 1:** Create a `Pair` to store the number and index. Convert the array to a list of pairs.
**Step 2:** Sort the list based on the number.
**Step 3:** Take the first number, subtract it from the target and search for the result in the remaining array.

Do this for each element.

**Note:** Use binary search because the array is sorted and it is faster.

Time complexity: The sorting takes `O(nlogn)` and for each element we are using binary search, so we are running `O(logn)` `n` times. So the final complexity comes out to be `O(nlogn)`.

## Code

```java
class Pair {
    public int number;
    public int index;

    Pair(int number, int index) {
        this.number = number;
        this.index = index;
    }
}

class Solution {
    public int findComplementary(List<Pair> pairs, int toFind) {
        int start = 0;
        int end = pairs.size() - 1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(pairs.get(mid).number == toFind) {
                return pairs.get(mid).index;
            }
            
            if(pairs.get(mid).number > toFind) {
                end = mid - 1;
            }
            
            if(pairs.get(mid).number < toFind) {
                start = mid + 1;
            }

            mid = (start + end) / 2;
        }

        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new Pair(nums[i], i));
        }
        int[] result = new int[2];

        // Sort the pairs based on the number
        Collections.sort(pairs, (Pair o1, Pair o2) -> {
            if (o1.number > o2.number) {
                return 1;
            } else {
                return -1;
            }
        });

        for(int i=0; i<pairs.size(); i++) {
            int current = pairs.get(i).number;
            int toFind = target - current;

            int complementaryIndex = findComplementary(pairs.subList(i+1, pairs.size()), toFind);

            if(complementaryIndex != -1) {
                result[0] = pairs.get(i).index;
                result[1] = complementaryIndex;
                break;
            }
        }

        return result;
    }
}
```

# Hashmap

We create a `Hashmap` whose key is the number and values is the index.

We iterate through the array and check if the difference of the target and the current element exist in the hashmap. If it does, we just return the current index and the index we found in the map. If not, we add this number and index to the map.

Time complexity: We go through the array only one, and adding to a Hashmap is a constant time operation, the complexity comes out to be `O(n)`.

# Code

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbersWithIndices = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(numbersWithIndices.containsKey(diff)) {
                return new int[] {i, numbersWithIndices.get(diff)};
            } else {
                numbersWithIndices.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}
```

