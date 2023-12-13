package Blind75.LongestSubstringWithoutRepeatingCharacters;

import Blind75.LongestSubstringWithoutRepeatingCharacters.Solutions.ISolution;
import Blind75.LongestSubstringWithoutRepeatingCharacters.Solutions.OnlyHashmapSolution;
import Blind75.LongestSubstringWithoutRepeatingCharacters.Solutions.SlidingWindowHashmapSolution;
import Blind75.LongestSubstringWithoutRepeatingCharacters.Solutions.SlidingWindowSetSolution;

class TestCase {
    public String s;

    TestCase(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}

public class LongestSubstringWithoutRepeatingCharactersDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase("abcabcbb"),
            new TestCase("bbbbb"),
            new TestCase("pwwkew"),
            new TestCase("dvdf"),
            new TestCase("bcaabcdba"),
        };

        ISolution[] solutions = new ISolution[] {
            new OnlyHashmapSolution(),
            new SlidingWindowSetSolution(),
            new SlidingWindowHashmapSolution()
        };

        for(ISolution solution : solutions) {
            System.out.println("--- " + solution.getClass().getSimpleName() + " ---");
            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                int result = solution.lengthOfLongestSubstring(testCase.s);
                System.out.println("Result: " + result);
            }
            System.out.println();
        }
    }
}
