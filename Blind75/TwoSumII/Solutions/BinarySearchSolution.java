package Blind75.TwoSumII.Solutions;

import java.util.Arrays;

public class BinarySearchSolution implements ISolution {
    private int findComplementary(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    @Override
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            int difference = target - current;

            int complementaryIndex = findComplementary(Arrays.copyOfRange(numbers, i + 1, numbers.length), difference);
            if (complementaryIndex != -1) {
                return new int[] { i + 1, complementaryIndex + 2 + i };
            }
        }

        return new int[] {};
    }
}
