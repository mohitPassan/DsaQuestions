package Blind75.TwoSum;

import java.util.Arrays;

import Blind75.TwoSum.Solutions.BruteForceSolution;
import Blind75.TwoSum.Solutions.HashmapSolution;
import Blind75.TwoSum.Solutions.ISolution;
import Blind75.TwoSum.Solutions.SortAndSearch;

class TestCase {
    public int[] nums;
    public int target;

    public TestCase(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    @Override
    public String toString() {
        return "nums: " + Arrays.toString(nums) + ", target: " + target;
    }
}

public class TwoSumDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new int[] { 2, 7, 11, 15 }, 9),
                new TestCase(new int[] { 3, 2, 4 }, 6),
                new TestCase(new int[] { 3, 3 }, 6)
        };

        ISolution[] soutions = new ISolution[] {
            new BruteForceSolution(),
            new SortAndSearch(),
            new HashmapSolution()
        };

        for(ISolution solution : soutions) {
            System.out.println(solution.getClass().getSimpleName());

            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int[] result = solution.TwoSum(testCase.nums, testCase.target);
                System.out.println("Result: " + Arrays.toString(result));
            }
        }
    }
}
