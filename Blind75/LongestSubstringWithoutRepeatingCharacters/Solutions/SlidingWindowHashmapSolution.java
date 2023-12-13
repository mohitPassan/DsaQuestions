package Blind75.LongestSubstringWithoutRepeatingCharacters.Solutions;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowHashmapSolution implements ISolution {
    @Override
    public int lengthOfLongestSubstring(String s) {
        char[] sc = s.toCharArray();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        Map<Character, Integer> characterMap = new HashMap<>();

        while (r < sc.length) {
            Integer lastFoundIndex = characterMap.get(sc[r]);

            if ((lastFoundIndex == null) || (l > lastFoundIndex)) {
                int length = r - l + 1;
                if (length > maxLength) {
                    maxLength = length;
                }

                characterMap.put(sc[r], r);
                r++;
            } else {
                l = lastFoundIndex + 1;
                characterMap.put(sc[r], r);
                r++;
            }
        }

        return maxLength;
    }
}
