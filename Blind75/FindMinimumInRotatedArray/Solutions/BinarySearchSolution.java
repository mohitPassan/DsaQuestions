package Blind75.FindMinimumInRotatedArray.Solutions;

public class BinarySearchSolution implements ISolution {
    @Override
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[start] <= nums[mid]) {
                // Left part is sorted
                if (nums[start] < min) {
                    min = nums[start];
                }
                start = mid + 1;
            } else {
                // Right part is sorted
                if (nums[mid] < min) {
                    min = nums[mid];
                }
                end = mid - 1;
            }
        }

        return min;
    }
}
