package Blind75.LongestConsecutiveSequence;

import Blind75.LongestConsecutiveSequence.Solutions.HashsetSolution;
import Blind75.LongestConsecutiveSequence.Solutions.ISolution;

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

public class LongestConsecutiveSequenceDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase(new int[] {100,4,200,1,3,2}),
            new TestCase(new int[] {0,3,7,2,5,8,4,6,0,1}),
            new TestCase(new int[] {}),
            new TestCase(new int[] {1,2,0,1})
        };

        ISolution[] solutions = new ISolution[] {
            new HashsetSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int result = solution.longestConsecutive(testCase.nums);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
    
}