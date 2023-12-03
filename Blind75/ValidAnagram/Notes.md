Given two strings `s` and `t`, return `true` _if_ `t` _is an anagram of_ `s`_, and_ `false` _otherwise_.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

**Input:** s = "anagram", t = "nagaram"
**Output:** true

**Example 2:**

**Input:** s = "rat", t = "car"
**Output:** false

**Constraints:**

- `1 <= s.length, t.length <= 5 * 104`
- `s` and `t` consist of lowercase English letters.

# Brute force approach

A brute force approach is to pick up a character from the first string and compare it with each character of the second string. If found, replace it with a . (dot) and in the check if the second string is all dots or not.

This gives a time complexity of `O(nm)` where `n` and `m` are lengths of the strings.

## Code

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        for(int i=0; i<sA.length; i++) {
            char current = sA[i];

            for(int j=0; j<tA.length; j++) {
                if(current == tA[j]) {
                    tA[j] = '.';
                    break;
                }
            }
        }

        for(char c : tA) {
            if(c != '.') {
                return false;
            }
        }

        return true;
    }
}
```

# Sorting solution

Another solution could be to sort both of the strings and then compare them. If they are equal, they are anagrams, otherwise they aren't.

The time complexity for sorting the arrays is `O(nlogn)`. The comparison can be done in `O(n)` time. So the final complexity comes out to be `O(nlogn)`.

## Code

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        Arrays.sort(sA);
        Arrays.sort(tA);

        s = new String(sA);
        t = new String(tA);

        return s.equals(t);
    }
}
```

# Frequency of characters

While traversing the first string, increment the count of each character. While traversing the second string, decrement the count of each character. In the end check if all the counts are zero or not.

Time complexity: `O(n + m)`

## Code

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        int[] count = new int[26];

        for(char c : sA) {
            count[c - 'a']++;
        }

        for(char c : tA) {
            count[c - 'a']--;
        }

        for(int i : count) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    }
}
```
