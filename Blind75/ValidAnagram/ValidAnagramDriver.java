package Blind75.ValidAnagram;

import Blind75.ValidAnagram.Solutions.BruteForceSolution;
import Blind75.ValidAnagram.Solutions.FrequencyOfCharacters;
import Blind75.ValidAnagram.Solutions.ISolution;
import Blind75.ValidAnagram.Solutions.SortingSolution;

public class ValidAnagramDriver {
    public static void main(String[] args) {
        String[][] cases = {
                { "anagram", "nagaram" },
                { "rat", "car" },
                { "aacc", "cacc" }
        };

        ISolution[] solutions = new ISolution[3];
        solutions[0] = new BruteForceSolution();
        solutions[1] = new SortingSolution();
        solutions[2] = new FrequencyOfCharacters();

        for(int i=0; i<solutions.length; i++) {
            System.out.println("Solution " + (i+1));

            for(String[] c : cases) {
                System.out.println("Test case: " + c[0] + ", " + c[1]);
                boolean result = solutions[i].isAnagram(c[0], c[1]);
                System.out.println("Result: " + result);
            }

            System.out.println();
        }
    }
}
