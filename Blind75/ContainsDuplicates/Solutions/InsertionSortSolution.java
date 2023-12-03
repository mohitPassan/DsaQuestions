package Blind75.ContainsDuplicates.Solutions;

public class InsertionSortSolution implements ISolution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            int j = i - 1;
            while (j >= 0 && current < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = current;

            if (j >= 0 && nums[j] == nums[j + 1]) {
                return true;
            }
        }

        return false;
    }
}
