package Blind75.FindMinimumInRotatedArray.Solutions;

public class LinearSearchSolution implements ISolution {
    @Override
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }

        return min;
    }
}
