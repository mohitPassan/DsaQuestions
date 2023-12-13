package Blind75.LongestSubstringWithoutRepeatingCharacters.Solutions;

import java.util.HashMap;
import java.util.Map;

public class OnlyHashmapSolution implements ISolution {
    @Override
    public int lengthOfLongestSubstring(String s) {
        char[] sC = s.toCharArray();
        Map<Character, Integer> characterMap = new HashMap<>();
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < sC.length;) {
            if (!characterMap.containsKey(sC[i])) {
                characterMap.put(sC[i], i);
                i++;
                count++;
            } else {
                int index = characterMap.get(sC[i]);
                i = index + 1;
                characterMap.clear();
                count = 0;
            }

            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }
}
