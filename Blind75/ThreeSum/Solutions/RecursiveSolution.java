// TLE on LeetCode

package Blind75.ThreeSum.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursiveSolution implements ISolution {
    private boolean search(int[] nums, int target) {
        for (int n : nums) {
            if (n == target) {
                return true;
            }
        }
        return false;
    }

    private List<List<Integer>> threeSumHelper(int[] nums, int toFind, int target) {
        List<List<Integer>> groups = new ArrayList<>();

        if (toFind == 1) {
            boolean result = search(nums, target);
            List<Integer> group = new ArrayList<>();

            if (result) {
                group.add(target);
            }

            groups.add(group);

            return groups;
        }

        if (nums.length == 0) {
            return groups;
        }

        int current = nums[0];
        List<List<Integer>> includingCurrent = threeSumHelper(Arrays.copyOfRange(nums, 1, nums.length), toFind - 1,
                target - current);
        List<List<Integer>> excludingCurrent = threeSumHelper(Arrays.copyOfRange(nums, 1, nums.length), toFind, target);

        for (List<Integer> g : includingCurrent) {
            if (g.size() != 0) {
                g.add(current);
                groups.add(g);
            }
        }

        for (List<Integer> g : excludingCurrent) {
            if (g.size() != 0) {
                groups.add(g);
            }
        }

        return groups;
    }

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> groups = threeSumHelper(nums, 3, 0);
        Set<List<Integer>> groupSet = new HashSet<>();
        List<List<Integer>> finalGroups = new ArrayList<>();

        for (List<Integer> g : groups) {
            Collections.sort(g);
            groupSet.add(g);
        }

        for (List<Integer> g : groupSet) {
            finalGroups.add(g);
        }

        return finalGroups;
    }
}
