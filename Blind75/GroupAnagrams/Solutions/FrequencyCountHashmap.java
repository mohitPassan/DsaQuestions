package Blind75.GroupAnagrams.Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCountHashmap implements ISolution {
    private String getFrequencyString(String word) {
        // Create an integer array of size 26
        int[] count = new int[26];

        // Iterate through each character of the word
        for(char c : word.toCharArray()) {
            // Increment the character count
            count[c - 'a']++;
        }

        // Iterate the character count array
        char c = 'a';
        StringBuilder frequencyString = new StringBuilder();
        for(int i : count) {
            // Keep appending the character with their frequency
            if(i != 0) {
                frequencyString.append(c + String.valueOf(i));
            }
            c++;
        }

        // Return the final string
        return frequencyString.toString();
    }

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through the array of strings
        for(String word : strs) {
            // Generate its frequency count string
            String frequencyString = getFrequencyString(word);

            // Check if this exist is the map
            if(!map.containsKey(frequencyString)) {
                // If it doesn't, create a new key and add self in that group
                List<String> group = new ArrayList<>();
                group.add(word);
                map.put(frequencyString, group);
            } else {
                // If it does, add self to the group
                map.get(frequencyString).add(word);
            }
        }

        // Compile the map and return
        List<List<String>> groups = new ArrayList<>(map.values());
        return groups;
    }
}
