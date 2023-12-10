package Blind75.ValidPalindrome.Solutions;

public class OptimizedSolution implements ISolution {
    private boolean isAlphaNumeric(char ch) {
        if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();

        int i=0, j=c.length-1;
        while(i<c.length && j>=0) {
            char ic = Character.toLowerCase(c[i]);
            char jc = Character.toLowerCase(c[j]);

            if(!isAlphaNumeric(ic)) {
                i++;
                continue;
            }
            
            if(!isAlphaNumeric(jc)) {
                j--;
                continue;
            }

            if(ic != jc) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
