package Blind75.FindMinimumInRotatedArray;

import java.util.Arrays;

import Blind75.FindMinimumInRotatedArray.Solutions.BinarySearchSolution;
import Blind75.FindMinimumInRotatedArray.Solutions.ISolution;
import Blind75.FindMinimumInRotatedArray.Solutions.LinearSearchSolution;

class TestCase {
    int[] nums;

    public TestCase(int[] nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return Arrays.toString(nums);
    }
}

public class FindMinimumInRotatedArrayDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase(new int[] {3,4,5,1,2}),
            new TestCase(new int[] {4,5,6,7,0,1,2}),
            new TestCase(new int[] {11,13,15,17}),
            new TestCase(new int[] {2,3,4,5,1}),
            new TestCase(new int[] {4}),
            new TestCase(new int[] {2,1}),
            new TestCase(new int[] {4,5,6,7,1,2,3}),
            new TestCase(new int[] {2,3,4,5,6,7,8,9,1}),
        };

        ISolution[] solutions = new ISolution[] {
            new LinearSearchSolution(),
            new BinarySearchSolution()
        };

        for(ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int result = solution.findMin(testCase.nums);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}