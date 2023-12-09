package Blind75.TopKFrequentElements.Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSortSolution implements ISolution {
    @Override
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                int c = map.get(i);
                map.put(i, ++c);
            } else {
                map.put(i, 1);
            }
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = (List<Integer>[]) new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int number = entry.getKey();

            if(bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(number);
        }
        
        int[] result = new int[k];
        int index = 0;
        for(int i=nums.length; i>=0; i--) {
            if(bucket[i] == null) {
                continue;
            }

            for(int n : bucket[i]) {
                result[index++] = n;
                if(index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
