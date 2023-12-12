package Blind75.ContainerWithMostWater;

import Blind75.ContainerWithMostWater.Solutions.ISolution;
import Blind75.ContainerWithMostWater.Solutions.NestedLoopsSolution;
import Blind75.ContainerWithMostWater.Solutions.TwoPointerSolution;

class TestCase {
    public int[] height;

    TestCase(int[] height) {
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i : height) {
            sb.append(i + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class ContainerWithMostWaterDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase(new int[] {1,8,6,2,5,4,8,3,7}),
            new TestCase(new int[] {1,1})
        };

        ISolution[] solutions = new ISolution[] {
            new NestedLoopsSolution(),
            new TwoPointerSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int result = solution.maxArea(testCase.height);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}