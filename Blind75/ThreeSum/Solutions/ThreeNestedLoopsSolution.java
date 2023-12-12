// This solution's time complexity is O(n^3).
// Gives TLE on LeetCode.

package Blind75.ThreeSum.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeNestedLoopsSolution implements ISolution {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> groups = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> group = new ArrayList<>();
                        group.add(nums[i]);
                        group.add(nums[j]);
                        group.add(nums[k]);

                        Collections.sort(group);
                        groups.add(group);
                    }
                }
            }
        }

        List<List<Integer>> finalGroups = new ArrayList<>(groups);
        return finalGroups;
    }
}
