package Blind75.ArrayProductExceptSelf.Solutions;

public class PrefixAndSuffixProductArraySolution implements ISolution {
    @Override
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] output = new int[size];

        // Prefix product
        int[] prefixProduct = new int[size];
        prefixProduct[0] = 1;
        for (int i = 1; i < size; i++) {
            prefixProduct[i] = nums[i - 1] * prefixProduct[i - 1];
        }

        // Suffix product
        int[] suffixProduct = new int[size];
        suffixProduct[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            suffixProduct[i] = nums[i + 1] * suffixProduct[i + 1];
        }

        for (int i = 0; i < size; i++) {
            output[i] = prefixProduct[i] * suffixProduct[i];
        }

        return output;
    }
}
