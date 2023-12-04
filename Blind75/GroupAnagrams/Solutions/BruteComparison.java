package Blind75.GroupAnagrams.Solutions;

import java.util.ArrayList;
import java.util.List;

public class BruteComparison implements ISolution {
    public boolean validAnagram(String s1, String s2) {
        // Initialise an array with size 26
        int[] count = new int[26];

        // Iterate the first string and increment each character count
        char[] s1Array = s1.toCharArray();
        for (char c : s1Array) {
            count[c - 'a']++;
        }

        // Now iterate the second string and decrement each character count
        char[] s2Array = s2.toCharArray();
        for (char c : s2Array) {
            count[c - 'a']--;
        }

        // The character count array should have all zeroes
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();

        // Iterate over the strings
        for (int i = 0; i < strs.length; i++) {
            // Take the current string
            String s1 = strs[i];

            // If this is a dot, skip
            if (s1 == ".") {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(s1);

            // Iterate from +1 position
            for (int j = i + 1; j < strs.length; j++) {
                // Take the current string
                String s2 = strs[j];

                // If this is a dot, skip
                if (s2 == ".") {
                    continue;
                }

                // See if they are anagrams
                boolean isValid = validAnagram(s1, s2);
                // If they are, combine them in a group and replace the second string with a dot
                if (isValid) {
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
