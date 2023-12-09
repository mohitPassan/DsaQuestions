package Blind75.ArrayProductExceptSelf;

import Blind75.ArrayProductExceptSelf.Solutions.ISolution;
import Blind75.ArrayProductExceptSelf.Solutions.NestedLoopsProductSolution;
import Blind75.ArrayProductExceptSelf.Solutions.PrefixAndSuffixProductArraySolution;

class TestCase {
    public int[] nums;

    public TestCase(int[] nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i : nums) {
            sb.append(i + " ");
        }
        sb.append("]");

        return sb.toString();
    }
}

public class ArrayProductExceptSelfDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase(new int[] {1,2,3,4}),
            new TestCase(new int[] {-1,1,0,-3,3}),
        };

        ISolution[] solutions = new ISolution[] {
            new NestedLoopsProductSolution(),
            new PrefixAndSuffixProductArraySolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int[] result = solution.productExceptSelf(testCase.nums);
                StringBuilder sb = new StringBuilder();
                sb.append("[ ");
                for (int i : result) {
                    sb.append(i + " ");
                }
                sb.append("]");
                System.out.println("Result: " + sb.toString());
            }
            System.out.println();
        }
    }
    
}