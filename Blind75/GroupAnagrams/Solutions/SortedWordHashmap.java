package Blind75.GroupAnagrams.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortedWordHashmap implements ISolution {
    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] cA = word.toCharArray();
            Arrays.sort(cA);
            String sortedWord = new String(cA);

            if (!map.containsKey(sortedWord)) {
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
