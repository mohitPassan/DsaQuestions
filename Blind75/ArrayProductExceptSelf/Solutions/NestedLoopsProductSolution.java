package Blind75.ArrayProductExceptSelf.Solutions;

public class NestedLoopsProductSolution implements ISolution {
    @Override
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] output = new int[size];

        for(int i=0; i<size; i++) {
            int product = 1;
            for(int j=0; j<size; j++) {
                if(i == j) {
                    continue;
                }

                product = nums[j] * product;
            }
            output[i] = product;
        }

        return output;
    }
}
