package Blind75.ThreeSum;

import java.util.List;

import Blind75.ThreeSum.Solutions.ISolution;
import Blind75.ThreeSum.Solutions.RecursiveSolution;
import Blind75.ThreeSum.Solutions.SortingAndTwoPointerSolution;
import Blind75.ThreeSum.Solutions.ThreeNestedLoopsSolution;

class TestCase {
    public int[] nums;

    TestCase(int[] nums) {
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

public class ThreeSumDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase(new int[] {-1,0,1,2,-1,-4}),
            new TestCase(new int[] {0,1,1}),
            new TestCase(new int[] {0,0,0})
        };

        ISolution[] solutions = new ISolution[] {
            new ThreeNestedLoopsSolution(),
            new RecursiveSolution(),
            new SortingAndTwoPointerSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                List<List<Integer>> result = solution.threeSum(testCase.nums);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}