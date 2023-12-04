package Blind75.ContainsDuplicates;

import java.util.Arrays;

import Blind75.ContainsDuplicates.Solutions.HashMapSolution;
import Blind75.ContainsDuplicates.Solutions.InsertionSortSolution;
import Blind75.ContainsDuplicates.Solutions.ISolution;

class TestCase {
    public int[] nums;

    TestCase(int[] nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return Arrays.toString(nums);
    }
}

public class ContainsDuplicatesDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase(new int[] { 1, 2, 3, 1 }),
            new TestCase(new int[] { 1, 2, 3, 4 }),
            new TestCase(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 })
        };
        
        ISolution[] solutions = new ISolution[] {
            new HashMapSolution(),
            new InsertionSortSolution()
        };

        for(ISolution solution : solutions) {
            System.out.println(solution.getClass().getSimpleName());
            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                boolean answer = solution.containsDuplicate(testCase.nums);
                System.out.println("Result: " + answer);
            }
            System.out.println();
        }
    }
}
