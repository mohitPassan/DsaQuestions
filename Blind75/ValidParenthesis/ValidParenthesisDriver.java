package Blind75.ValidParenthesis;

import Blind75.ValidParenthesis.Solutions.ISolution;
import Blind75.ValidParenthesis.Solutions.StackSolution;

class TestCase {
    String s;

    public TestCase(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}

public class ValidParenthesisDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase("()"),
            new TestCase("()[]{}"),
            new TestCase("(]"),
            new TestCase("((({}[]){[]}))"),
            new TestCase("]"),
            new TestCase("]]][[["),
            new TestCase("[]]]]")
        };

        ISolution[] solutions = new ISolution[] {
            new StackSolution()
        };

        for(ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                boolean result = solution.isValid(testCase.s);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }


}
