package Blind75.ContainsDuplicates.Solutions;

import java.util.HashMap;
import java.util.Map;

public class HashMapSolution implements ISolution {
    @Override
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i : nums) {
            // If the number already exists, return true.
            if(hm.get(i) != null) {
                return true;
            } else {
                hm.put(i, 1);
            }
        }

        // If we are here, it means there were no duplicates
        // so, return false.
        return false;
    }
}
