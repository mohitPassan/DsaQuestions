package Blind75.ValidAnagram.Solutions;

public class BruteForceSolution implements ISolution {
    @Override
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        for(int i=0; i<sA.length; i++) {
            char current = sA[i];

            for(int j=0; j<tA.length; j++) {
                if(current == tA[j]) {
                    tA[j] = '.';
                    break;
                }
            }
        }

        for(char c : tA) {
            if(c != '.') {
                return false;
            }
        }

        return true;
    }
}
