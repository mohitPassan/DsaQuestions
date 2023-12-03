package Blind75.ContainsDuplicates;

import Blind75.ContainsDuplicates.Solutions.HashMapSolution;
import Blind75.ContainsDuplicates.Solutions.InsertionSortSolution;
import Blind75.ContainsDuplicates.Solutions.ISolution;

public class ContainsDuplicatesDriver {
    public static void main(String[] args) {
        int[][] cases = {
            { 1, 2, 3, 1 },
            { 1, 2, 3, 4 },
            { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }
        };
        
        ISolution[] solutions = new ISolution[2];
        solutions[0] = new HashMapSolution();
        solutions[1] = new InsertionSortSolution();

        for(int i=0; i<solutions.length; i++) {
            System.out.println("Solution " + (i+1));
            for(int[] c : cases) {
                boolean answer = solutions[0].containsDuplicate(c);
                System.out.println("Result: " + answer);
            }
            System.out.println();
        }
    }
}
