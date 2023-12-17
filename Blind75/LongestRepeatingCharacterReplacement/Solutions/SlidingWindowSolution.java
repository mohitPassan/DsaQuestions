package Blind75.LongestRepeatingCharacterReplacement.Solutions;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowSolution implements ISolution {
    int getMaxCountCharacter(Map<Character, Integer> map) {
        int maxCount = 1;
        for (Integer c : map.values()) {
            if (c > maxCount) {
                maxCount = c;
            }
        }
        return maxCount;
    }

    @Override
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        Map<Character, Integer> characterMap = new HashMap<>();
        int result = 1;
        char[] sC = s.toCharArray();
        characterMap.put(sC[0], 1);

        while (r < sC.length) {
            int windowLength = r - l + 1;
            int maxCount = getMaxCountCharacter(characterMap);
            boolean isValid = (windowLength - maxCount) <= k;

            if (isValid) {
                if (windowLength > result) {
                    result = windowLength;
                }
                r++;

                if (r >= sC.length) {
                    continue;
                }

                if (characterMap.containsKey(sC[r])) {
                    int count = characterMap.get(sC[r]);
                    characterMap.put(sC[r], count + 1);
                } else {
                    characterMap.put(sC[r], 1);
                }
            } else {
                int count = characterMap.get(sC[l]);
                characterMap.put(sC[l], count - 1);
                l++;
            }
        }

        return result;
    }
}
