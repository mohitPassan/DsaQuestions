package Blind75.GroupAnagrams;

import java.util.Arrays;
import java.util.List;

import Blind75.GroupAnagrams.Solutions.BruteComparison;
import Blind75.GroupAnagrams.Solutions.ISolution;
import Blind75.GroupAnagrams.Solutions.SortedWordHashmap;

class TestCase {
    public String[] strs;

    TestCase(String[] strs) {
        this.strs = strs;
    }

    @Override
    public String toString() {
        return Arrays.toString(strs);
    }
}

public class GroupAnagramsDriver {
    public static void main(String[] args) {
        TestCase[] testCases = new TestCase[] {
            new TestCase(new String[] {"eat","tea","tan","ate","nat","bat"}),
            new TestCase(new String[] {""}),
            new TestCase(new String[] {"a"})
        };

        ISolution[] solutions = new ISolution[] {
            new BruteComparison(),
            new SortedWordHashmap()
        };

        for(ISolution solution : solutions) {
            System.out.println(solution.getClass().getSimpleName());

            for(TestCase testCase : testCases) {
                System.out.println("Test case: " + testCase.toString());
                // Passing a clone because one solution changes the content of the
                // array, corrupting the test case for the next solution
                List<List<String>> groups = solution.groupAnagrams(testCase.strs.clone());
                System.out.println("Result: " + groups.toString());
            }
        }
    }
}
