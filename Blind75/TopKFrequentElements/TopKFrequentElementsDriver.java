package Blind75.TopKFrequentElements;

import Blind75.TopKFrequentElements.Solutions.BucketSortSolution;
import Blind75.TopKFrequentElements.Solutions.ISolution;
import Blind75.TopKFrequentElements.Solutions.MaxHeapSolution;

class TestCase {
    public int[] nums;
    public int k;

    TestCase(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i : nums) {
            sb.append(i + " ");
        }
        sb.append("]");

        return "nums = " + sb.toString() + " : k = " + k;
    }
}

public class TopKFrequentElementsDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase(new int[] { 1, 1, 1, 2, 2, 3 }, 2),
                new TestCase(new int[] { 1 }, 1),
                new TestCase(new int[] { 1, 2 }, 2),
        };

        ISolution[] solutions = new ISolution[] {
                new BucketSortSolution(),
                new MaxHeapSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int[] result = solution.topKFrequent(testCase.nums, testCase.k);
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