package Blind75.SearchInRotatedSortedArray;

import java.util.Arrays;

import Blind75.SearchInRotatedSortedArray.Solutions.BinarySearchSolution;
import Blind75.SearchInRotatedSortedArray.Solutions.ISolution;
import Blind75.SearchInRotatedSortedArray.Solutions.LinearSearchSolution;

class TestCase {
    int[] nums;
    int target;

    public TestCase(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    @Override
    public String toString() {
        return "Array: " + Arrays.toString(nums) + " Target: " + target;
    }
}

public class SearchInRotatedSortedArrayDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0),
                new TestCase(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3),
                new TestCase(new int[] { 1 }, 0),
        };

        ISolution[] solutions = new ISolution[] {
                new LinearSearchSolution(),
                new BinarySearchSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int result = solution.search(testCase.nums, testCase.target);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }

}
