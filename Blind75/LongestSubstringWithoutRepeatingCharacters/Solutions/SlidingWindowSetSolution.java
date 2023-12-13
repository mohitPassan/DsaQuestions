package Blind75.LongestSubstringWithoutRepeatingCharacters.Solutions;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindowSetSolution implements ISolution {
    @Override
    public int lengthOfLongestSubstring(String s) {
        char[] sc = s.toCharArray();
        Set<Character> characterSet = new HashSet<>();
        int maxLength = 0;
        int l = 0;
        int r = 0;

        while (r < sc.length) {
            if (!characterSet.contains(sc[r])) {
                characterSet.add(sc[r]);
                int length = r - l + 1;
                if (length > maxLength) {
                    maxLength = length;
                }

                r++;
            } else {
                characterSet.remove(sc[l]);
                l++;
            }

        }

        return maxLength;
    }
}
