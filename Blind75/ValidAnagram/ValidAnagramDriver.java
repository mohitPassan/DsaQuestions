package Blind75.ValidAnagram;

import Blind75.ValidAnagram.Solutions.BruteForceSolution;
import Blind75.ValidAnagram.Solutions.FrequencyOfCharacters;
import Blind75.ValidAnagram.Solutions.ISolution;
import Blind75.ValidAnagram.Solutions.SortingSolution;

class TestCase {
    public String s;
    public String t;

    public TestCase(String s, String t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public String toString() {
        return "{ " + s + ", " + t + " }";
    }
}

public class ValidAnagramDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
                new TestCase("anagram", "nagaram"),
                new TestCase("rat", "car"),
                new TestCase("aacc", "cacc"),
        };

        ISolution[] solutions = new ISolution[] {
                new BruteForceSolution(),
                new SortingSolution(),
                new FrequencyOfCharacters()
        };

        for (ISolution solution : solutions) {
            System.out.println(solution.getClass().getSimpleName());
            for (TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                boolean result = solution.isAnagram(testCase.s, testCase.t);
                System.out.println("Result: " + result);
            }

            System.out.println();
        }
    }
}
