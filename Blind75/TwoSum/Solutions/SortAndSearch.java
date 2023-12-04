package Blind75.TwoSum.Solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair {
    public int number;
    public int index;

    Pair(int number, int index) {
        this.number = number;
        this.index = index;
    }
}

public class SortAndSearch implements ISolution {
    public int findComplementary(List<Pair> pairs, int toFind) {
        int start = 0;
        int end = pairs.size() - 1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(pairs.get(mid).number == toFind) {
                return pairs.get(mid).index;
            }
            
            if(pairs.get(mid).number > toFind) {
                end = mid - 1;
            }
            
            if(pairs.get(mid).number < toFind) {
                start = mid + 1;
            }

            mid = (start + end) / 2;
        }

        return -1;
    }

    @Override
    public int[] TwoSum(int[] nums, int target) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new Pair(nums[i], i));
        }
        int[] result = new int[2];

        // Sort the pairs based on the number
        Collections.sort(pairs, (Pair o1, Pair o2) -> {
            if (o1.number > o2.number) {
                return 1;
            } else {
                return -1;
            }
        });

        for(int i=0; i<pairs.size(); i++) {
            int current = pairs.get(i).number;
            int toFind = target - current;

            int complementaryIndex = findComplementary(pairs.subList(i+1, pairs.size()), toFind);

            if(complementaryIndex != -1) {
                result[0] = pairs.get(i).index;
                result[1] = complementaryIndex;
                break;
            }
        }

        return result;
    }
}
