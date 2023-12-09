package Blind75.LongestConsecutiveSequence.Solutions;

import java.util.HashSet;
import java.util.Set;

public class HashsetSolution implements ISolution {
    @Override
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();

        for (int i : nums) {
            numSet.add(i);
        }

        int longestSequence = 1;
        for (int num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            } else {
                int s = num + 1;
                int count = 1;
                while (numSet.contains(s)) {
                    count++;
                    s++;
                }
                if (count > longestSequence) {
                    longestSequence = count;
                }
            }
        }

        return longestSequence;
    }
}
