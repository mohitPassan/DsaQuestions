package Blind75.ValidPalindrome;

import Blind75.ValidPalindrome.Solutions.ISolution;
import Blind75.ValidPalindrome.Solutions.OptimizedSolution;
import Blind75.ValidPalindrome.Solutions.ValidPalindromeSolution;

class TestCase {
    public String s;

    public TestCase(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return this.s;
    }
}

public class ValidPalindromeDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase("A man, a plan, a canal: Panama"),
                new TestCase("race a car"),
                new TestCase(" "),
                new TestCase("..!()..."),
                new TestCase("0P"),
                new TestCase(",,,,,,,,,,,,acva"),
        };

        ISolution[] solutions = new ISolution[] {
            new ValidPalindromeSolution(),
            new OptimizedSolution()
        };

        for (ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                boolean result = solution.isPalindrome(testCase.s);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}
