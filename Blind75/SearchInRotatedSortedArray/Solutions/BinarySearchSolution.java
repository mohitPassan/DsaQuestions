package Blind75.SearchInRotatedSortedArray.Solutions;

public class BinarySearchSolution implements ISolution {
    @Override
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] < nums[end]) {
                // The whole array is sorted, just do what we do in binary search
                if (target < nums[mid]) {
                    // Find in the left part
                    end = mid - 1;
                    continue;
                } else {
                    // Find in the right part
                    start = mid + 1;
                    continue;
                }
            }

            if (nums[start] <= nums[mid]) {
                // Left part is sorted
                int minInLeft = nums[start];
                int maxInLeft = nums[mid];

                if (target < minInLeft || target > maxInLeft) {
                    // The element is not here, search on the right part
                    start = mid + 1;
                    continue;
                } else {
                    // The element is here, search in the left part
                    end = mid - 1;
                    continue;
                }
            }

            if (nums[mid] <= nums[end]) {
                // Right part is sorted
                int minInRight = nums[mid];
                int maxInRight = nums[end];

                if (target < minInRight || target > maxInRight) {
                    // The element is not here, search on the left part
                    end = mid - 1;
                    continue;
                } else {
                    // The element is here, search in the right part
                    start = mid + 1;
                    continue;
                }
            }
        }

        return -1;
    }
}
