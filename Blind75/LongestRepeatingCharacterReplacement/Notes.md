# Problem statement

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

Return _the length of the longest substring containing the same letter you can get after performing the above operations_.

**Example 1:**

**Input:** s = "ABAB", k = 2
**Output:** 4
**Explanation:** Replace the two 'A's with two 'B's or vice versa.

**Example 2:**

**Input:** s = "AABABBA", k = 1
**Output:** 4
**Explanation:** Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

**Constraints:**

- `1 <= s.length <= 105`
- `s` consists of only uppercase English letters.
- `0 <= k <= s.length`



# Sliding window

We use a `sliding window` to solve this. We check if the current window is valid or not, if it is valid, we check if this is greater than the max length or not. Now, how to check if the current window is valid or not?

First we find the length of the window (`r - l + 1`) and subtract it with the frequency of the character that has the highest frequency. This number will tell us how many characters we will have to replace to make this window contain all same characters. If this number is less than `k`, then this window is valid, otherwise it is not.

The main concept is above, now to go into some technical details, we use a left and right pointer to maintain our window and we also maintain a `Hashmap` to store count of each character.

If the window is valid, we increase the length of the window (`r++`) and increment the character count. if it is not valid, we decrease the length of the window (`l++`) and also decrement the character count.

## Code

```java
class Solution {
    int getMaxCountCharacter(Map<Character, Integer> map) {
        int maxCount = 1;
        for(Integer c : map.values()) {
            if(c > maxCount) {
                maxCount = c;
            }
        }
        return maxCount;
    }

    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        Map<Character, Integer> characterMap = new HashMap<>();
        int result = 1;
        char[] sC = s.toCharArray();
        characterMap.put(sC[0], 1);

        while(r < sC.length) {
            int windowLength = r - l + 1;
            int maxCount = getMaxCountCharacter(characterMap);
            boolean isValid = (windowLength - maxCount) <= k;

            if(isValid) {
                if(windowLength > result) {
                    result = windowLength;
                }
                r++;

                if(r >= sC.length) {
                    continue;
                }

                if(characterMap.containsKey(sC[r])) {
                    int count = characterMap.get(sC[r]);
                    characterMap.put(sC[r], count+1);
                } else {
                    characterMap.put(sC[r], 1);
                }
            } else {
                int count = characterMap.get(sC[l]);
                characterMap.put(sC[l], count-1);
                l++;
            }
        }

        return result;
    }
}
```

(This code seems a bit messy, if we can improve this, we should.)