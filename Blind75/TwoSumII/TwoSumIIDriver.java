package Blind75.TwoSumII;

import Blind75.TwoSumII.Solutions.BinarySearchSolution;
import Blind75.TwoSumII.Solutions.ISolution;
import Blind75.TwoSumII.Solutions.TwoPointerSolution;

class TestCase {
    public int[] numbers;
    public int target;

    TestCase(int[] nums, int target) {
        this.numbers = nums;
        this.target = target;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Numbers: [ ");
        for (int i : numbers) {
            sb.append(i + " ");
        }
        sb.append("] : " + "Target: " + target);
        return sb.toString();
    }
}

public class TwoSumIIDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new int[] { 2, 7, 11, 15 }, 9),
                new TestCase(new int[] { 2, 3, 4 }, 6),
                new TestCase(new int[] { -1, 0 }, -1)
        };

        ISolution[] solutions = new ISolution[] {
                new BinarySearchSolution(),
                new TwoPointerSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int[] result = solution.twoSum(testCase.numbers, testCase.target);
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
