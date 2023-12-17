package Blind75.LongestRepeatingCharacterReplacement;

import Blind75.LongestRepeatingCharacterReplacement.Solutions.ISolution;
import Blind75.LongestRepeatingCharacterReplacement.Solutions.SlidingWindowSolution;

class TestCase {
    public String s;
    public int k;

    TestCase(String s, int k) {
        this.s = s;
        this.k = k;
    }

    @Override
    public String toString() {
        return "String: " + s + ", k : " + k;
    }
}

public class LongestRepeatingCharacterReplacementDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase("ABAB", 2),
            new TestCase("AABABBA", 1),
            new TestCase("ABAA", 0)
        };
        
        ISolution[] solutions = new ISolution[] {
            new SlidingWindowSolution()
        };
        
        for(ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int result = solution.characterReplacement(testCase.s, testCase.k);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}
