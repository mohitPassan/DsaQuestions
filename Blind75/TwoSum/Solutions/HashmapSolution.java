package Blind75.TwoSum.Solutions;

import java.util.HashMap;
import java.util.Map;

public class HashmapSolution implements ISolution {
    @Override
    public int[] TwoSum(int[] nums, int target) {
        Map<Integer, Integer> numbersWithIndices = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(numbersWithIndices.containsKey(diff)) {
                return new int[] {i, numbersWithIndices.get(diff)};
            } else {
                numbersWithIndices.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}
