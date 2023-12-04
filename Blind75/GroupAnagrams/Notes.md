# Problem statement

Given an array of strings `strs`, group **the anagrams** together. You can return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

**Input:** strs = \["eat","tea","tan","ate","nat","bat"]
**Output:** \[\["bat"],\["nat","tan"],\["ate","eat","tea"]]

**Example 2:**

**Input:** strs = \[""]
**Output:** \[\[""]]

**Example 3:**

**Input:** strs = \["a"]
**Output:** \[\["a"]]

**Constraints:**

- `1 <= strs.length <= 104`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.



# Brute force

Comparing each element with each element and checking if they are anagrams or not. If they are, we add them to the group and convert the second string to a dot, so that we don't start doing the comparison again. After each iteration, we add this created group to a list and return it.

Time complexity: The worst case is that not a single element is anagram with another, so the groups size will be same as that of the array and each element will be compared with each and every element. This makes the time complexity of the code `O(n)`.

## Code

```java
class Solution {
    public boolean validAnagram(String s1, String s2) {
        // Initialise an array with size 26
        int[] count = new int[26];

        // Iterate the first string and increment each character count
        char[] s1Array = s1.toCharArray();
        for(char c : s1Array) {
            count[c - 'a']++;
        }

        // Now iterate the second string and decrement each character count
        char[] s2Array = s2.toCharArray();
        for(char c : s2Array) {
            count[c - 'a']--;
        }

        // The character count array should have all zeroes
        for(int i : count) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();

        // Iterate over the strings
        for(int i=0; i<strs.length; i++) {
            // Take the current string
            String s1 = strs[i];

            // If this is a dot, skip
            if(s1 == ".") {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(s1);

            // Iterate from +1 position
            for(int j=i+1; j<strs.length; j++) {
                // Take the current string
                String s2 = strs[j];

                // If this is a dot, skip
                if(s2 == ".") {
                    continue;
                }

                // See if they are anagrams
                boolean isValid = validAnagram(s1, s2);
                // If they are, combine them in a group and replace the second string with a dot
                if(isValid) {
                    group.add(s2);
                    strs[j] = ".";
                } else {
                    // If not, continue
                    continue;
                }
            }

            groups.add(group);
        }

        return groups;
    }
}
```

# Hashmap

We know that if two strings are anagrams, their sorted strings will be the same. So, we first sort each and every element of an array. We now create a map in which the key will be the sorted string and value will be the group of anagrams.

We iterate through the sorted string list and then check if this string exists as a key or not, if it does, we add the original string to this group otherwise we create a new group and assign it to the key.

Time complexity: Sorting takes `nlogn` time and it is done `length of string array (l)` times. Accessing and putting new keys in a map takes constant time. So the final complexity comes out to be `O(l*nlogn)`

## Code

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word : strs) {
            char[] cA = word.toCharArray();
            Arrays.sort(cA);
            String sortedWord = new String(cA);

            if(!map.containsKey(sortedWord)) {
                List<String> group = new ArrayList<>();
                group.add(word);
                map.put(sortedWord, group);
            } else {
                map.get(sortedWord).add(word);
            }

        }

        List<List<String>> groups = new ArrayList<>(map.values());
        return groups;
    }
}
```


