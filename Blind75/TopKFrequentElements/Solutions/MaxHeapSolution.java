package Blind75.TopKFrequentElements.Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeapSolution implements ISolution {
    @Override
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Counting and storing each element's frequency in a map
        for (int i : nums) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.put(i, ++count);
            } else {
                map.put(i, 1);
            }
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            } else {
                return -1;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }
}
