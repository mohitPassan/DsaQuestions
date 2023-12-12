// Accepted: O(n^2)

package Blind75.ThreeSum.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAndTwoPointerSolution implements ISolution {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> groups = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int current = nums[i];

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = current + nums[l] + nums[r];

                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    groups.add(Arrays.asList(new Integer[] { current, nums[l], nums[r] }));

                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);

                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                }
            }
        }

        return groups;
    }
}
